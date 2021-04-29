package cn.bdqn.service.impl;

import cn.bdqn.dao.UserDao;
import cn.bdqn.dao.impl.UserDaoImpl;
import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import cn.bdqn.util.DataBaseUtil;

public class UserServiceImpl implements UserService{

	private UserDao user = new UserDaoImpl(DataBaseUtil.getConnection());
	
//	µÇÂ¼
	@Override
	public User Login(String name, String pwd) {
		return user.Login(name, pwd);
	}

}
