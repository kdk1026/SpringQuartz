package kr.co.test.function.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.LogDeclare;
import common.spring.resolver.ParamCollector;
import common.util.map.ResultSetMap;
import kr.co.test.function.mapper.MemberMapper;

@Service
public class MyBatisServiceImpl extends LogDeclare implements MyBatisService {
	
	@Autowired
	private MemberMapper userMapper;

	@Override
	public List<ResultSetMap> listUser() {
		return userMapper.selectAll();
	}

	@Override
	public void addUser(ParamCollector paramCollector) {
		userMapper.insert(paramCollector.getMapAll());
	}

	@Override
	public ResultSetMap getUser(ParamCollector paramCollector) {
		return userMapper.selectOne(paramCollector.getMapAll());
	}

	@Override
	public void modifyUser(ParamCollector paramCollector) {
		userMapper.update(paramCollector.getMapAll());
	}

	@Override
	public void removeUser(ParamCollector paramCollector) {
		userMapper.delete(paramCollector.getMapAll());
	}
	
}
