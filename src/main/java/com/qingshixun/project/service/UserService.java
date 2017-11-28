package com.qingshixun.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingshixun.project.dao.UserDao;
import com.qingshixun.project.model.ChartData;
import com.qingshixun.project.model.UserModel;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public List<UserModel> findUser() {
		return userDao.findUser();
	}

	@Transactional
	public void deleteUser(UserModel userModel) {
		userDao.deleteUser(userModel);
	}

	@Transactional
	public List<UserModel> selectPage(int pageNow, int pageSize) {
		return userDao.selectPage(pageNow, pageSize);
	}

	@Transactional
	public int selectTotalSize() {
		return userDao.selectTotalSize();
	}

	@Transactional
	public void addUser(UserModel userModel) {
		userDao.addUser(userModel);

	}

	@Transactional
	public List<UserModel> findName(int pageNow, int pageSize, String nameKey) {
		return userDao.findName(pageNow, pageSize, nameKey);

	}

	@Transactional
	public ChartData getUserGenderData() {
		List genderNumberList = userDao.getUserGenderNumber();
		int genderNumberCount = genderNumberList.size();
		String[] names = new String[genderNumberCount];
		String[] values = new String[genderNumberCount];
		// 遍历统计数据，转换成Char.js所需要的数据格式
		int n = genderNumberCount;
		for (int i = 0; i < n; i++) {
			Object[] genderNumbers = (Object[]) genderNumberList.get(i);
			// 性别标签名称，如：male、famale
			names[i] = "\"" + String.valueOf(genderNumbers[1]) + "\"";
			values[i] = String.valueOf(genderNumbers[0]);
		}
		ChartData userGenderData = new ChartData();
		userGenderData.setNames("[" + String.join(",", names) + "]");
		userGenderData.setValues("[" + String.join(",", values) + "]");
		return userGenderData;
	}

	@Transactional
	public ChartData getUserCreateData() {
		List createDateNumberList = userDao.getUserCreateData();
		int createDateNumberCount = createDateNumberList.size();
		String[] names = new String[createDateNumberCount];
		String[] values = new String[createDateNumberCount];
		// 遍历统计数据，转换成Char.js所需要的数据格式
		int n = createDateNumberCount;
		for (int i = 0; i < n; i++) {
			Object[] createDateNumber = (Object[]) createDateNumberList.get(i);
			// 性别标签名称，如：male、famale
			names[i] = "\"" + String.valueOf(createDateNumber[1]) + "\"";
			values[i] = String.valueOf(createDateNumber[0]);
		}
		ChartData userCreateData = new ChartData();
		userCreateData.setNames("[" + String.join(",", names) + "]");
		userCreateData.setValues("[" + String.join(",", values) + "]");
		return userCreateData;
	}

	@Transactional
	public UserModel getUser(int id) {
		return userDao.getUser(id);
	}
}
