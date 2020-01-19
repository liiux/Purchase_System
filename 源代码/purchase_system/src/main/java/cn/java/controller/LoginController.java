package cn.java.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.java.entity.OneMenu;
import cn.java.mapper.LoginMapper;
import cn.java.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "登录", tags = "登录")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 
	 * @param username 从jsp页面接收
	 * @param pwd      从jsp页面接收
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login.do")
	@ApiOperation(value = "登录", notes = "登录", httpMethod = "POST", response = boolean.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "job_num", value = "输入的工号", dataType = "String"),
			@ApiImplicitParam(name = "pwd", value = "输入的密码明文", dataType = "String"),
			@ApiImplicitParam(name = "session", value = "传参所需", dataType = "HttpSession"), })
	public String login(String job_num, String pwd, HttpSession session) throws Exception {
		// 调用业务方法
		boolean flag = loginService.isLoginSuccess(job_num, pwd);
		// 根据业务方法返回的结果，决定跳转页面
		if (flag) {
			String user_name = loginService.getName(job_num, pwd);
			session.setAttribute("user_name", user_name);
			// 获取菜单
			Long user_id = loginService.getId(job_num, pwd);
			session.setAttribute("user_id", user_id);
			List<OneMenu> oneMenuList = loginService.selectMenus(user_id);
			session.setAttribute("oneMenuList", oneMenuList);
			return "redirect:/pages/admin/index.jsp";
		} else {
			return "redirect:/pages/admin/login.jsp";
		}
	}
}
