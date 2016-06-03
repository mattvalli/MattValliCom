package com.mattvalli.RapidFramework.service.UserSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mattvalli.RapidFramework.dao.UserSystem.NameDao;

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
	
}
