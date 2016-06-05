package com.mattvalli.RapidFramework.UserSystem.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mattvalli.RapidFramework.UserSystem.model.Name;
import com.mattvalli.RapidFramework.dao.AbstractDao;

@Repository("nameDao")
public class NameDaoImpl extends AbstractDao<Integer, Name> implements NameDao {
	
	// CREATE
		// QUERY
		public String query_create_table() {
			return NameDao.QUERY_CREATE_TABLE;
		}
	
		// INTERFACE
		@Override
		public void saveName(Name name) {
			persist(name);
		}

	
	// READ
	@Override
	public Name findById(int id) {
		return getByKey(id);
	}

	@Override
	public Name findNameByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eqOrIsNull(NameDao.COLUMN_NAME, name));
		return (Name) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Name> findAllNames() {
		Criteria criteria = createEntityCriteria();
		return (List<Name>) criteria.list();
	}

	
	// DELETE
	@Override
	public void deleteNameById(int id) {
		Query query = getSession().createSQLQuery(QUERY_DELETE_BY_ID);
		query.setString(NameDao.COLUMN_ID, Integer.toString(id));
		query.executeUpdate();
	}

	@Override
	public void deleteNameByName(String name) {
		Query query = getSession().createSQLQuery(QUERY_DELETE_BY_NAME);
		query.setString(NameDao.COLUMN_NAME, name);
		query.executeUpdate();
	}
}
