package org.yang.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.yang.javabeans.HouseOrder;

/**
 * 针对表HouseOrder以及实体类houseOrder的操作
 * 创建时间:2017年8月10日 下午3:41:39
 * 最后修改人:杨殊缘
 * 最后修改时间:2017年8月10日 下午3:41:39
 * @author 杨殊缘
 */
public interface HouseOrderDaoImpl {

	/**
	 * 将一条订房订单存入数据库中
	 * 非关键字段serial和createTime,其余均为关键字段
	 * @param order 包含所有关键字段的订房订单记录对象
	 */
	public void insert(HouseOrder order);

	/**
	 * 通过表记录主键值查询对应的记录信息
	 * @param serial houseOrder表记录的主键值
	 * @return 将对应的表记录信息封装到实体类对象中进行返回
	 */
	public HouseOrder selectOrderById(String serial);

	/**
	 * 将一条订房订单修改后的信息重新存入到数据库中
	 * 主键值是必须存在的
	 * @param order 被修改后的订单信息
	 */
	public void update(HouseOrder order);

	/**
	 * 通过条件查询将订房订单中的记录有限的查询出来
	 * @param criteria 查询条件集合
	 * @return 将查询结果作为集合返回
	 */
	public List<HouseOrder> selectOrderByCriteria(DetachedCriteria criteria);

}
