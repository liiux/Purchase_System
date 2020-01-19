package cn.java.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.java.service.BuyPlanInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "采购员管理", tags = "采购员管理")
public class BuyPlanInfoController {

	@Autowired
	private BuyPlanInfoService buyPlanInfoService;

	private Long save_user_id;

	@RequestMapping("/buyPlanInfo.do")
	@ApiOperation(value = "获取待采购的采购计划", notes = "获取待采购的采购计划", httpMethod = "POST", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"),
			@ApiImplicitParam(name = "user_id", value = "当前的用户ID", dataType = "Long"), })
	public String buyPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Long user_id, Model model) {
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = buyPlanInfoService.getPlanInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("user_id", user_id);
		return "admin/bill/buyPlanInfo.jsp";
	}

	@RequestMapping("/selectSupplier.do")
	@ApiOperation(value = "获取所有供应商的列表", notes = "获取所有供应商的列表", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "plan_id", value = "待选择供应商的订单ID", dataType = "Integer"),
			@ApiImplicitParam(name = "user_id", value = "当前的用户ID", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String selectSupplier(Long plan_id, Long user_id, Model model) {
		List<Map<String, Object>> supplierInfo = buyPlanInfoService.getAllSupplier();
		model.addAttribute("supplierInfo", supplierInfo);
		model.addAttribute("plan_id", plan_id);
		model.addAttribute("user_id", user_id);
		return "admin/bill/selectSupplier.jsp";
	}

	@RequestMapping(value = "/setSupplier.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ApiOperation(value = "选择供应商", notes = "为传入的plan_id对应的订单选择一个供应商，对应为supplier_info中的信息", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "待选择供应商的订单ID", dataType = "Integer"),
			@ApiImplicitParam(name = "supplier_info", value = "选择的供应商的信息", dataType = "String"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String setSupplier(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, String plan_id, String supplier_info,
			Model model) {
		String[] si = supplier_info.split("——");
		Long supplier_id = Long.valueOf(si[0]);
		String[] info = plan_id.split("-");
		Long planId = Long.valueOf(info[0]);
		Long user_id = Long.valueOf(info[1]);
		buyPlanInfoService.setSupplier(supplier_id, planId);
		buyPlanInfoService.setBuy(planId);
		LocalDate Date = LocalDate.now();
		String buy_date = Date.getYear() + "-" + Date.getMonthValue() + "-" + Date.getDayOfMonth();
		buyPlanInfoService.setBuyDate(buy_date, planId);
		buyPlanInfoService.setBuyer(user_id, planId);
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = buyPlanInfoService.getPlanInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("user_id", user_id);
		return "admin/bill/buyPlanInfo.jsp";
	}

	@RequestMapping("/getMyBuyPlanInfo.do")
	@ApiOperation(value = "获取我的采购订单信息", notes = "根据传入的user_id查询对应的订单信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "user_id", value = "当前的用户ID", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String getMyBuyPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Long user_id, Model model) {
		if (user_id != null) {
			save_user_id = user_id;
		}
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = buyPlanInfoService.getMyPlanInfo(save_user_id, pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("user_id", user_id);
		return "admin/bill/getMyPlanInfo.jsp";
	}
}
