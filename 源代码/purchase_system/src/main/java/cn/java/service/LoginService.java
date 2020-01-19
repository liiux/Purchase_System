package cn.java.service;

import java.util.List;

import cn.java.entity.OneMenu;

public interface LoginService {

	boolean isLoginSuccess(String job_num, String pwd) throws Exception;

	String getName(String job_num, String pwd) throws Exception;

	List<OneMenu> selectMenus(Long userId);

	Long getId(String job_num, String pwd) throws Exception;

}