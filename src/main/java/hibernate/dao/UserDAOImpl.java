package hibernate.dao;

import hibernate.model.EntityUser;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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

}
