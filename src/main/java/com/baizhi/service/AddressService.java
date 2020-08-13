package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	/**
	 * 根据当前用户id查询已有的地址信息
	 * @param id
	 * @return
	 */
	public List<Address> queryByUserId();
	/**
	 * 根据已有的地址id查询信息
	 * @param id
	 * @return
	 */
	public Address queryByAddressId(String id);
}
