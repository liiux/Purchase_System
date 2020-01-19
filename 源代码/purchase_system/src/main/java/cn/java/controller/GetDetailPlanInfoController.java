package cn.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.java.service.GetDetailPlanInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "获取订单详细信息", tags = "获取订单详细信息")
public class GetDetailPlanInfoController {

	@Autowired
	private GetDetailPlanInfoService getDetailPlanInfoService;

	private Long save_plan_id;

	@RequestMapping("/getDetailPlanInfo.do")
	@ApiOperation(value = "获取订单详细信息", notes = "获取传入的plan_id对应的订单的详细信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "选择的订单的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String getPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model, Long plan_id) {
		if (plan_id != null) {
			save_plan_id = plan_id;
		}
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = getDetailPlanInfoService.selectDeatilPlanInfo(save_plan_id, pageNum,
				pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/getDetailPlanInfo.jsp";
	}

}
