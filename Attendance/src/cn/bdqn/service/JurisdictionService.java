package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Jurisdiction;
import cn.bdqn.entity.Layui;

public interface JurisdictionService {
	List<Jurisdiction> SeleUserMenu(int userid);//��ѯ�û���ӦȨ��

	List<Jurisdiction> SelectAllJurisdictions();//��ѯ����Ȩ��
	
	List<Jurisdiction> seleBtn();//��ѯ������ť

	int deleteAllot(int id);//ɾ��

	Jurisdiction echo(int id);//����

	List<Jurisdiction> seleMunuid(int menuid);//��ѯ�˵�id

	int updateAllot(Jurisdiction menu);//�޸�Ȩ��

	Jurisdiction seleName(int pid);//��ѯ�ϼ�Ȩ����

	int insertAllot(Jurisdiction menu);//����Ȩ��
	
	Layui<Jurisdiction> SelectAllJurisdiction();//��ѯ����Ȩ��
	
	List<Jurisdiction> seleType(int type);//��ѯ�ϼ�Ȩ����
	
	List<Jurisdiction> SelectJurBtn(int parentid);//��ѯ����Ȩ�޶�Ӧ��ť
}
