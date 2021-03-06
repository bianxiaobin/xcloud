package com.xc.bl.user.service;

import com.xc.bl.entities.User;

public interface IUserInfoService {
	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 根据uid获得用户信息
	 * 
	 * @param uid
	 *            用户ID
	 * @return User
	 */
	public User getUserById(long uid);

	/**
	 * 根据用户手机号获得用户信息
	 * 
	 * @param phoneNum
	 *            用户手机号
	 * @return User
	 */
	public User getUserByPhone(long phoneNum);

	/**
	 * 更新用户最后登录时间
	 * 
	 * @param uid
	 * @return 更新条数
	 */
	public int UpdLastLoginTime(long uid);
	
	/**
	 * 获得用户数
	 * @return
	 */
	public long getUserCount();
}
