package org.yang.service.impl;

import java.util.List;

import org.yang.formbeans.Destine;
import org.yang.javabeans.House;
import org.yang.javabeans.HouseOrder;

/**
 * 操作订房系统的相关操作
 * 创建时间:2017-08-09 11:39:31
 * 最后修改人:杨殊缘
 * 最后修改时间:2017-08-09 11:42:12
 * @author 杨殊缘
 *
 */
public interface HouseServiceImpl {

	/**
	 * 将系统中的所有房间类型作为集合返回
	 * 需要判断房间是否可以进行订房,将客满的房间排除出去
	 * @return 所有可以被会员进行订房的操作的房间
	 */
	public List<House> canUseHouse();

	/**
	 * 通过house表主键进行精准查询,将对应的记录作为实体进行返回
	 * @param house 要查询的house表记录的主键
	 * @return 将对应的表记录填充到对象中作为返回
	 */
	public House getHouseById(int house);

	/**
	 * 将参数中的相关数据封装成对应的订房订单并持久化到数据库中
	 * @param destine 装载必要的参数信息
	 * @return 0表示账户余额不足,1表示订单成功,其他表示订单失败
	 */
	public int destineOrder(Destine destine);

	/**
	 * 将给定的房间的价格修改为新的价格,修改成功返回新的价格,修改失败返回旧有的价格信息
	 * @param house 指定要进行修改的房间记录
	 * @param price 该房间新的价格
	 * @return 将数据库中现有的对应房间的价格信息作为返回
	 */
	public double changePrice(int house, double price);

	/**
	 * 将指定房间的状态进行交换,1变为0,0变为1
	 * 操作完成完成true,操作失败返回false
	 * @param house 要进行状态修改的房间记录的主键值
	 * @return 该操作的制定状态,成功为true
	 */
	public boolean changeState(int house);

	/**
	 * 根据已有的参数构建一条新的房间记录信息并保存到数据库中
	 * state默认为true,表示可以进行订房操作
	 * @param type 新的房间记录的名称
	 * @param price 新的房间记录的价格
	 */
	public void newHouse(String type, double price);

	/**
	 * 修改一条订单的审核状态,审核通过需要执行相应的扣款及通知操作
	 * @param serial 需要修改的订单记录的主键
	 * @param option 审核操作,1表示审核通过,0表示驳回
	 * @return 相应的订单操作是否成功完成
	 */
	public boolean auditingOrder(String serial, int option);

	/**
	 * 通过指定的订单信息向该会员发送一条信息提示会员进行验证码验证操作
	 * @param serial 针对的订单记录的主键值
	 */
	public void msg(String serial);

	/**
	 * 修改一条订房系统的订单将其的预留状态改为0
	 * 使用验证码校验当前操作是否可以执行
	 * 产生相应的退单记录,根据option分辨退单原因
	 * 对会员发送信息提示
	 * @param serial 要退单的订单记录的主键
	 * @param option 退单的原因:1表示正常退单,0表示逾期退单
	 * @param check_num 通过验证码验证该操作是否可以被执行
	 */
	public void backOrder(String serial, int option, String check_num);

	/**
	 * 根据条件查找历史的订房订单记录信息
	 * @param day 查询的历史范围0以及小于0表示查询全部，单位为天
	 * @param back 是否要查询退单记录,true表示部查询退单记录,false表示查询退单记录
	 * @return 将查询到的订单信息作为集合返回
	 */
	public List<HouseOrder> historyOrder(int day , boolean back);

	/**
	 * 将所有的房间信息不做条件的直接查询出来
	 * 需要一定得排序操作,按是否可以预定进行排序
	 * @return 将查询到的房间记录信息作为结果集返回
	 */
	public List<House> allHouse();

	
}
