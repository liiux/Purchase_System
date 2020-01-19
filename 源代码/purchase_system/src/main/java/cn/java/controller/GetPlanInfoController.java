package cn.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.java.service.GetPlanInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "我的采购计划", tags = "我的采购计划")
public class GetPlanInfoController {

	@Autowired
	private GetPlanInfoService getPlanInfoService;

	private Long save_user_id;

	@RequestMapping("/getPlanInfo.do")
	@ApiOperation(value = "获取我的采购计划信息", notes = "获取传入的user_id查找订单中planer_id=user_id的订单信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "user_id", value = "当前的用户ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String getPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model, Long user_id) {
		if (user_id != null) {
			save_user_id = user_id;
		}
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = getPlanInfoService.selectAllPlanInfo(save_user_id, pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/getPlanInfo.jsp";
	}

}
