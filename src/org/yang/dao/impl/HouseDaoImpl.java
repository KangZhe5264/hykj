package org.yang.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.yang.javabeans.House;

/**
 * 针对表house以及实体类House进行相关操作
 * 创建时间:2017年8月10日 下午2:36:16
 * 最后修改人:杨殊缘
 * 最后修改时间:2017年8月10日 下午2:36:16
 * @author 杨殊缘
 */
public interface HouseDaoImpl {

	/**
	 * 通过查询参数进行相关的查询
	 * @param criteria 查询条件的封装集合
	 * @return 将符合查询条件的house表记录作为集合进行返回
	 */
	public List<House> selectByCriteria(DetachedCriteria criteria);

	/**
	 * 通过表记录主键值找到对应的记录作为返回
	 * @param house house表记录的主键值
	 * @return 主键值对应的表记录信息
	 */
	public House selectById(int house);

	/**
	 * 将一条修改过的房间信息重新保存到数据库中,其中主键值是必须的存在
	 * @param house 包含了主键值以及更新后数据的房间信息对象
	 */
	public void update(House house);

	/**
	 * 将一条房间类型的信息存入数据库中
	 * 除主键外的参数都必须存在
	 * @param house 存放房间类型记录信息的实体类对象
	 */
	public void insert(House house);

}
