package cn.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.java.entity.OneMenu;
import cn.java.mapper.LoginMapper;
import cn.java.service.LoginService;
import cn.java.utils.MD5;

@Service
@Transactional(readOnly = false)
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Transactional(readOnly = true)
	@Override
	public boolean isLoginSuccess(String job_num, String pwd) throws Exception {
		if (job_num == null || pwd == null) {
			return false;
		}
		// 检查输入合法性
		String regex1 = "\\w{3,12}";
		String regex2 = "\\w{6,12}";
		boolean flag1 = job_num.matches(regex1);
		boolean flag2 = pwd.matches(regex2);

		if (flag1 && flag2) {
			// 将密码加密，加密后传递给Mapper层
			String miwen = MD5.finalMD5(pwd);
			int flag = loginMapper.login(job_num, miwen);
			return flag >= 1 ? true : false;
		}
		return false;
	}

	@Transactional(readOnly = true)
	@Override
	public String getName(String job_num, String pwd) throws Exception {
		String miwen = MD5.finalMD5(pwd);
		int flag = loginMapper.login(job_num, miwen);
		if (flag >= 1) {
			return loginMapper.getName(job_num, miwen);
		}
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public Long getId(String job_num, String pwd) throws Exception {
		String miwen = MD5.finalMD5(pwd);
		int flag = loginMapper.login(job_num, miwen);
		if (flag >= 1) {
			return loginMapper.getId(job_num, miwen);
		}
		return null;
	}

	@Override
	public List<OneMenu> selectMenus(Long userId) {
		return loginMapper.getMenus(userId);
	}
}
