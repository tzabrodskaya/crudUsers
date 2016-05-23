package hibernate.dao;

import hibernate.model.EntityUser;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<EntityUser> list() {
		@SuppressWarnings("unchecked")
		List<EntityUser> listUser = (List<EntityUser>) sessionFactory.getCurrentSession()
				.createCriteria(EntityUser.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

	@Override
	@Transactional
	public void saveOrUpdate(EntityUser user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	@Transactional
	public void delete(int id) {
		EntityUser userToDelete = get(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
	}

	@Override
	@Transactional
	public List<EntityUser> getName(EntityUser user) {
		int age  = user.getAge();
		List<EntityUser> listUser= list();
		List<EntityUser> listResult = new ArrayList<EntityUser>();
		for (EntityUser user1: listUser) {
			if (user1.getAge()==age)
				listResult.add(user1);
		}

		//System.out.println(listResult.size());
		if (!listResult.isEmpty()) {
			return listResult;
		}

		return null;
	}

	@Override
	@Transactional
	public EntityUser get(int id) {
		String hql = String.format("from EntityUser where id=%s", id);
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<EntityUser> listUser = (List<EntityUser>) query.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		}

		return null;
	}

}
