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

import cn.java.service.AddPlanInfoService;
import cn.java.service.GetDetailPlanInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "添加采购计划", tags = "添加采购计划")
public class AddPlanInfoController {

	@Autowired
	private AddPlanInfoService addPlanInfoService;

	@Autowired
	private GetDetailPlanInfoService getDetailPlanInfoService;

	private Long save_maxPlan;

	private String save_num;

	private String save_price;

	@RequestMapping("/addPlan_first.do")
	@ApiOperation(value = "跳转到添加采购计划主页面", notes = "", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "user_id", value = "当前的用户id", dataType = "Long"),
			@ApiImplicitParam(name = "session", value = "传参所需", dataType = "HttpSession"), })
	public String addPlan_main(Long user_id, HttpSession session) {
		session.setAttribute("user_id", user_id);
		return "admin/bill/addPlanInfo_first.jsp";
	}

	@RequestMapping("/addPlan.do")
	@ApiOperation(value = "新建采购计划", notes = "通过传入的用户id，新建一个采购计划", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "user_id", value = "当前的用户id", dataType = "Long"),
			@ApiImplicitParam(name = "session", value = "传参所需", dataType = "HttpSession"), })
	public String addPlan(Long user_id, HttpSession session) {
		LocalDate Date = LocalDate.now();
		String date = Date.getYear() + "-" + Date.getMonthValue() + "-" + Date.getDayOfMonth();
		boolean flag = addPlanInfoService.addPlan(date, user_id);
		if (flag) {
			Long maxPlan = addPlanInfoService.getMaxPlan();
			session.setAttribute("maxPlan", maxPlan);
			return "admin/bill/addPlanInfo_second.jsp";
		}
		return "admin/bill/addPlanInfo_first.jsp";
	}

	@RequestMapping(value = "/addPlanInfo.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ApiOperation(value = "添加原料到相对应的采购计划中", notes = "通过原料名称、数量和单价insert一个原料，再增加到订单ID为maxPlan的采购计划中", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"),
			@ApiImplicitParam(name = "name", value = "原料名称", dataType = "String"),
			@ApiImplicitParam(name = "num", value = "原料数量", dataType = "String"),
			@ApiImplicitParam(name = "price", value = "原料单价", dataType = "String"),
			@ApiImplicitParam(name = "maxPlan", value = "当前的采购计划的ID", dataType = "Long"), })
	public String addPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "4") Integer pageSize, Model model, String name, String num,
			String price, Long maxPlan) {
		if (maxPlan != null) {
			save_maxPlan = maxPlan;
		}
		if (num != null) {
			save_num = num;
		}
		if (price != null) {
			save_price = price;
		}
		int Num = Integer.parseInt(save_num);
		float Price = Float.parseFloat(save_price);
		boolean flag = addPlanInfoService.addPlanInfo(name, Num, Price);
		if (flag) {
			Long maxFood = addPlanInfoService.getMaxFood();
			addPlanInfoService.addFoodPlan(save_maxPlan, maxFood);
			model.addAttribute("maxPlan", save_maxPlan);
			// 分页之后返回的数据
			List<Map<String, Object>> infoList = getDetailPlanInfoService.selectDeatilPlanInfo(save_maxPlan, pageNum,
					pageSize);
			// 将infoList封装到PageInfo工具类中
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
			model.addAttribute("pageInfo", pageInfo);
			return "admin/bill/addPlanInfo.jsp";
		} else {
			return "admin/bill/addPlanInfo.jsp";
		}
	}
}
