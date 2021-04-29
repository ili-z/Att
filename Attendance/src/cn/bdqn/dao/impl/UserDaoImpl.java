package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.UserDao;
import cn.bdqn.entity.User;
import cn.bdqn.util.DataBaseUtil;

public class UserDaoImpl extends BaseDao implements UserDao{

	public UserDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	ResultSet set = null;
//	µÇÂ¼  id  name       sex  roleid  address  classid  pwd     userCode  phone   email
	@Override
	public User Login(String name,String pwd) {
		String sql = "select id from `user` where userCode = ? and pwd = ?";
		Object[] pstms = {name,pwd};
		User user = null;
		int num = 0;
		try {
			set = super.excuteQuery(sql, pstms);
			if(set != null) {
				while (set.next()) {
					user = new User();
					user.setId(set.getInt("id"));
					user.setName(set.getString("name"));
					user.setSex(set.getInt("sex"));
					user.setRoleid(set.getInt("roleid"));
					user.setAddress(set.getString("address"));
					user.setClassid(set.getInt("classid"));
					user.setPwd(set.getString("pwd"));
					user.setUserCode(set.getString("userCode"));
					user.setPhone(set.getString("phone"));
					user.setEmail(set.getString("email"));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		
		return user;
	}
	


}
