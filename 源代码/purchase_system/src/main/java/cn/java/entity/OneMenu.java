package cn.java.entity;

import java.util.List;

public class OneMenu {
	private Long id;// 一级菜单的主键

	private String oneName;// 一级菜单名

	private List<TwoMenu> twoMenuList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOneName() {
		return oneName;
	}

	public void setOneName(String oneName) {
		this.oneName = oneName;
	}

	public List<TwoMenu> getTwoMenuList() {
		return twoMenuList;
	}

	public void setTwoMenuList(List<TwoMenu> twoMenuList) {
		this.twoMenuList = twoMenuList;
	}
}
