package cn.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.JurisdictionDao;
import cn.bdqn.entity.Jurisdiction;
import cn.bdqn.util.DataBaseUtil;

public class JurisdictionDaoImpl extends BaseDao implements JurisdictionDao{

	public JurisdictionDaoImpl(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	public static Logger logger = Logger.getLogger(BaseDao.class.getName());
	ResultSet set = null;
//	用户权限
	@Override
	public List<Jurisdiction> SeleUserMenu(int userid) {
		String sql = "SELECT * FROM `jurisdiction` WHERE id IN (SELECT menuid FROM `user_menu` WHERE userid = ?)";
		Object[] pstms = {userid};
		List<Jurisdiction> list = new ArrayList<Jurisdiction>();
		Jurisdiction jur = null;
		try {
			set = super.excuteQuery(sql, pstms);
			if(set != null) {
				while (set.next()) {
					jur = new Jurisdiction();
					jur.setId(set.getInt("id"));
					jur.setButton(set.getString("button"));
					jur.setQname(set.getString("qname"));
					jur.setParentid(set.getInt("parentid"));
					jur.setType(set.getInt("type"));
					jur.setUrl(set.getString("url"));
					jur.setJs(set.getString("js"));
					jur.setIsdelete(set.getInt("isdelete"));
					list.add(jur);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return list;
	}
	
}
