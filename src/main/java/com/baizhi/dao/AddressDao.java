package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao {
	/**
	 * 根据当前用户id查询已有的地址信息
	 * @param id
	 * @return
	 */
	public List<Address> queryByUserId(String id);
	/**
	 * 根据已有的地址id查询信息
	 * @param id
	 * @return
	 */
	public Address queryByAddressId(String id);
	/**
	 * 添加地址信息
	 * @param address
	 */
	public void addOneAddress(Address address);
	/**
	 * 修改地址信息
	 * @param address
	 */
	public void updateOneAddress(Address address);
}
