package com.mattvalli.RapidFramework.Model.UserSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mattvalli.RapidFramework.Model.UserSystem.dao.NameDao;
import com.mattvalli.RapidFramework.Model.UserSystem.model.Name;

@Service("nameService")
@Transactional
public class NameServiceImpl implements NameService {
	
	// PROPERTIES
	@Autowired
	NameDao mNameDao;
	
	@Override
	public String queryCreateTable() {
		return mNameDao.query_create_table();
	}
	
	@Override
	public Name findById(int id) {
		return mNameDao.findById(id);
	}

	@Override
	public void save(Name name) {
		mNameDao.saveName(name);
	}

	@Override
	public void update(Name name) {
		Name entity = mNameDao.findById(name.getId());
		if (entity != null) {
			entity.setDisplayName(name.getDisplayName());
			entity.setFirstName(name.getFirstName());
			entity.setLastName(name.getLastName());
			entity.setNames(name.getNames());
		}
	}

	@Override
	public void deleteNameById(Integer id) {
		mNameDao.deleteNameById(id);
	}

	@Override
	public List<Name> findAllNames() {
		return mNameDao.findAllNames();
	}

	@Override
	public Name findNameById(Integer id) {
		return mNameDao.findById(id);
	}

	@Override
	public Name findName(String name) {
		return mNameDao.findNameByName(name);
	}

	@Override
	public boolean isNameUnique(Integer id, String name) {
		// TODO This logic doesn't really ask the real question of name equality/uniqueness
		Name entity = findNameById(id);
        return ( entity == null || ((id != null) && (entity.getId() == id)));
	}

}
