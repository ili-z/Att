package cn.bdqn.dao;

import java.util.List;

import cn.bdqn.entity.Jurisdiction;


public interface JurisdictionDao {
	List<Jurisdiction> SeleUserMenu(int userid);//��ѯ�û���ӦȨ��

	List<Jurisdiction> SelectAllJurisdictions();//��ѯ����Ȩ��
	
	List<Jurisdiction> seleBtn();//��ѯ������ť

	int deleteAllot(int id);//ɾ��

	Jurisdiction echo(int id);//����

	List<Jurisdiction> seleMunuid(int jurid);//��ѯ�˵�id

	int updateAllot(Jurisdiction jur);//�޸�Ȩ��

	Jurisdiction seleName(int pid);//��ѯ�ϼ�Ȩ����

	int insertAllot(Jurisdiction jur);//����Ȩ��
	
	List<Jurisdiction> seleType(int type);//��ѯ�ϼ�Ȩ����
	
	List<Jurisdiction> SelectJurBtn(int parentid);//��ѯ����Ȩ�޶�Ӧ��ť

}
