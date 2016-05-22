package hibernate.dao;

import hibernate.model.EntityUser;

import java.util.List;

public interface UserDAO {
	public List<EntityUser> list();
}
