package com.xc.bl.config.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xc.bl.config.dao.IConfigDao;
import com.xc.bl.entities.Config;
import com.xc.bl.entities.dao.IBaseDAO;

@Repository("configDao")
public class ConfigDaoImpl implements IConfigDao {

	@Autowired
	private IBaseDAO<Config> baseDAO;

	@Override
	public Config getCfgByName(String name) {
		return baseDAO
				.get("from Config where cfgName=?", new Object[] { name });
	}

	@Override
	public void updCfgByName(Config config) {
		config.setConfigId(getCfgByName(config.getCfgName()).getConfigId());
		baseDAO.update(config);
	}

	@Override
	public List<Config> findConfig() {
		return baseDAO.find("from Config");
	}

}
