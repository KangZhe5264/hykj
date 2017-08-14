package org.yang.dao;

import java.util.List;
import java.util.Map;

import org.yang.javabeans.Leaguer;
/**
 * @author yangwc
 * @function Leaguer��DAO��ӿ�
 */

public interface LeaguerDAO {
	/**
	 * add by ����Ե
	 * ͨ������openid�ҵ���Ӧ�Ļ�Ա��Ϣ
	 * @param openid ��Ա��openid,���ڲ���Ψһ�Ļ�Ա
	 * @return ��Ψһ��Ӧ �Ļ�Ա��¼��ʵ�������ķ�ʽ����
	 */
	public Leaguer getUserById(String openid);
	
	/**
	 * ��Աע��
	 * @param leaguer Ҫ��ӵĻ�Ա
	 */
	public void add(Leaguer leaguer);
	
	/**
	 * ��Ա��Ϣ�޸�
	 * @param leaguer Ҫ�޸ĵĻ�Ա��Ϣ
	 */
	public void Eidt(Leaguer leaguer);
	
	/**
	 * ��Ա��Ϣɾ��
	 * @param leaguer Ҫɾ���Ļ�Ա��Ϣ
	 */
	public void Delete(Leaguer leaguer);
	
	/**
	 * ��Ա��Ϣɾ��
	 * @return List<leaguer> ȫ����Ա��Ϣ
	 */
	public List<Leaguer> QueryAll();
	
	/**
	 * @param Map ��ѯ����<K,V>
	 * @return List<leaguer> ȫ����Ա��Ϣ
	 */
	public List<Leaguer> QueryByParam(Map<String,Object> paramMap);
}
