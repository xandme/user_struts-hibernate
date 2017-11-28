package com.qingshixun.project.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qingshixun.project.model.ChartData;
import com.qingshixun.project.model.Page;
import com.qingshixun.project.model.UserModel;
import com.qingshixun.project.service.UserService;

@Component("userAction")
public class UserAction {
	@Autowired
	private UserService userService;
	private List<UserModel> listUser;
	private UserModel userModel;
	private ChartData userGenderData;
	private ChartData userCreateData;
	private Page page;
	private int pageNow = 1; // 初始页为第一页
	private int pageSize = 10; // 每页数据为10条，可调节
	private int totalSize = 0; // 总数据行数
	private String nameKey;

	public String list() {
		listUser = userService.selectPage(pageNow, 10);
		System.out.println("pageNow" + pageNow);
		System.out.println("内容数据：" + listUser);
		totalSize = userService.selectTotalSize();
		page = new Page(pageNow, 10, totalSize);
		return "list";
	}

	public String delete() {
		System.out.println("id" + userModel.getId());
		userService.deleteUser(userModel);
		return list();
	}

	public String add() {
		System.out.println("ADD");
		userModel = new UserModel();
		System.out.println("add" + userModel);
		return "add";
	}

	public String addUser() {
		userModel.setUpdateDate(new Date());
		System.out.println(userModel.toString());
		userService.addUser(userModel);
		return "addUser";
	}

	public String analyze() {
		userGenderData = userService.getUserGenderData();
		userCreateData = userService.getUserCreateData();
		System.out.println(userGenderData.toString());
		return "analyze";
	}

	public String findName() {
		System.out.println(nameKey);
		listUser = userService.findName(pageNow, 10, nameKey);
		return "findName";
	}

	public String edit() {
		System.out.println("EDIT");
		userModel = userService.getUser(userModel.getId());
		return "edit";
	}

	public List<UserModel> getListUser() {
		return listUser;
	}

	public void setListUser(List<UserModel> listUser) {
		this.listUser = listUser;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getNameKey() {
		return nameKey;
	}

	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}

	public ChartData getUserGenderData() {
		return userGenderData;
	}

	public void setUserGenderData(ChartData userGenderData) {
		this.userGenderData = userGenderData;
	}

	public ChartData getUserCreateData() {
		return userCreateData;
	}

	public void setUserCreateData(ChartData userCreateData) {
		this.userCreateData = userCreateData;
	}

}
