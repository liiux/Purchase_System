package cn.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.java.entity.OneMenu;
import cn.java.entity.TwoMenu;

/**
 * 登录模块
 * 
 * @author liu
 *
 */

public interface LoginMapper {

	/**
	 * 
	 * @param username 工号
	 * @param pwd      密文
	 * @return
	 */
	@Select("select count(*) from user where job_num=#{job_num} and pwd=#{pwd}")
	int login(String job_num, String pwd);

	@Select("select user_name from user where job_num=#{job_num} and pwd=#{pwd}")
	String getName(String job_num, String pwd);

	@Select("select id from user where job_num=#{job_num} and pwd=#{pwd}")
	Long getId(String job_num, String pwd);

	List<OneMenu> getMenus(Long userId);
}
