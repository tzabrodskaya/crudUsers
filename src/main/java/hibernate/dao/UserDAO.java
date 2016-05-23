package hibernate.dao;

import hibernate.model.EntityUser;

import java.util.List;

public interface UserDAO {
	public List<EntityUser> list();

	public EntityUser get(int id);

	public void saveOrUpdate(EntityUser user);

	public void delete(int id);

	List<EntityUser> getName(EntityUser user);
}
