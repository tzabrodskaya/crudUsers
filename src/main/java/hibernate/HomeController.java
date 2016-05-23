package hibernate;

import hibernate.dao.UserDAO;
import hibernate.model.EntityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    private UserDAO userDao;

    @RequestMapping("/")
    public ModelAndView handleRequest(@RequestParam(required = false) Integer page) throws Exception {
        List<EntityUser> listUsers = userDao.list();
        ModelAndView model = new ModelAndView("UserList");

        PagedListHolder<EntityUser> pagedListHolder = new PagedListHolder<EntityUser>(listUsers);
        pagedListHolder.setPageSize(20);
        model.addObject("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;


        model.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addObject("userList", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            model.addObject("userList", pagedListHolder.getPageList());
        }
        return model;
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView model =  new ModelAndView("UserSearch");
        EntityUser user = new EntityUser();
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    public ModelAndView searchUser(@ModelAttribute EntityUser user) {
        List<EntityUser> listUsers = userDao.getName(user);
        ModelAndView model =  new ModelAndView("UserSearchResult");
        model.addObject("userList", listUsers);
        System.out.println(listUsers.get(0).getName());
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newUser() {
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("user", new EntityUser());
        return model;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        EntityUser user = userDao.get(userId);
        ModelAndView model = new ModelAndView("UserForm");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userDao.delete(userId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute EntityUser user) {
        userDao.saveOrUpdate(user);
        return new ModelAndView("redirect:/");
    }

}
