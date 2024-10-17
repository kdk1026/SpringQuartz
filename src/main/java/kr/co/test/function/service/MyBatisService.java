package kr.co.test.function.service;

import java.util.List;

import common.spring.resolver.ParamCollector;
import common.util.map.ResultSetMap;

public interface MyBatisService {

	public List<ResultSetMap> listUser();
	
	public void addUser(ParamCollector paramCollector);
	
	public ResultSetMap getUser(ParamCollector paramCollector);
	
	public void modifyUser(ParamCollector paramCollector);
	
	public void removeUser(ParamCollector paramCollector);
	
}
