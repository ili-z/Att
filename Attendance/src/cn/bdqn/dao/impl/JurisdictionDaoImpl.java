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
	
	@Override
	public List<Jurisdiction> SelectAllJurisdictions() {
		String sql = "SELECT * FROM `jurisdiction`";
		List<Jurisdiction> list = new ArrayList<Jurisdiction>();
		Jurisdiction jur = null;
		try {
			set = super.excuteQuery(sql, null);
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
	
	@Override
	public int deleteAllot(int id) {
		String sql = "DELETE FROM `jurisdiction` WHERE id = ?";
		Object[] parms = { id };
		return super.excuteUpdate(sql, parms);
	}
	
	@Override
	public Jurisdiction echo(int id) {
		String sql = "select id, button, qname, parentid, `type`, url, js, isdelete from jurisdiction where id=?";
		Object[] parms = { id };
		Jurisdiction jur = null;
		try {
			set = super.excuteQuery(sql, parms);
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
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return jur;
	}
	
	@Override
	public List<Jurisdiction> seleMunuid(int jurid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int updateAllot(Jurisdiction jur) {
		String sql = "UPDATE `jurisdiction` SET button=?, qname=?, parentid=?, `type`=? ,url=? ,js=?, isdelete=? WHERE id=?";
		Object[] parms = { jur.getButton(),jur.getQname(),jur.getParentid(),jur.getType(),jur.getUrl(),jur.getJs(),jur.getIsdelete(),jur.getId()};
		return super.excuteUpdate(sql, parms);
	}
	@Override
	public Jurisdiction seleName(int pid) {
		String sql = "SELECT qname FROM `jurisdiction` where id=?";
		List<Jurisdiction> list = new ArrayList<Jurisdiction>();
		Jurisdiction jur = null;
		Object[] parms = { pid };
		String name = null;
		try {
			set = super.excuteQuery(sql, parms);
			if(set != null) {
				while (set.next()) {
					jur = new Jurisdiction();
					jur.setQname(set.getString("qname"));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			DataBaseUtil.closeAll(set, null, null);
		}
		return jur;
	}
	@Override
	public int insertAllot(Jurisdiction jur) {
		String sql = "INSERT INTO `jurisdiction` (button, qname, parentid, `type` ,url,js,isdelete) VALUES(?, ?, ?, ?, ?, ?, ?)";
		Object[] parms = { jur.getButton(),jur.getQname(),jur.getParentid(),jur.getType(),jur.getUrl(),jur.getJs(),jur.getIsdelete() };
		return super.excuteUpdate(sql, parms);
	}

	@Override
	public List<Jurisdiction> seleBtn() {
		String sql = "select id, button from btn";
		Jurisdiction jur = null;
		List<Jurisdiction> list = new ArrayList<Jurisdiction>();
		try {
			set = super.excuteQuery(sql, null);
			if(set != null) {
				while (set.next()) {
					jur = new Jurisdiction();
					jur.setId(set.getInt("id"));
					jur.setButton(set.getString("button"));
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

	@Override
	public List<Jurisdiction> seleType(int type) {
		String sql = "SELECT id,qname,`type` FROM `jurisdiction` WHERE `type`=?";
		Object[] parms = { type };
		Jurisdiction jur = null;
		List<Jurisdiction> list = new ArrayList<Jurisdiction>();
		try {
			set = super.excuteQuery(sql, parms);
			if(set != null) {
				while (set.next()) {
					jur = new Jurisdiction();
					jur.setId(set.getInt("id"));
					jur.setQname(set.getString("qname"));
					jur.setType(set.getInt("type"));
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

	@Override
	public List<Jurisdiction> SelectJurBtn(int parentid) {
		String sql = "SELECT * FROM `jurisdiction` WHERE parentid=? AND TYPE=3";
		Object[] parms = { parentid };
		Jurisdiction jur = null;
		List<Jurisdiction> list = new ArrayList<Jurisdiction>();
		try {
			set = super.excuteQuery(sql, parms);
			if(set != null) {
				while (set.next()) {
					jur = new Jurisdiction();
					jur.setId(set.getInt("id"));
					jur.setQname(set.getString("qname"));
					jur.setButton(set.getString("button"));
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
