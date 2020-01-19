package cn.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.java.service.CheckPlanService;
import cn.java.service.GetDetailPlanInfoService;
import cn.java.service.ReceiveInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "接收员管理", tags = "接收员管理")
public class ReceiveInfoController {

	@Autowired
	private ReceiveInfoService receiveInfoService;

	@Autowired
	private GetDetailPlanInfoService getDetailPlanInfoService;

	@Autowired
	private CheckPlanService checkPlanService;

	private Long save_plan_id;

	@RequestMapping("/receiveInfo.do")
	@ApiOperation(value = "获取所有采购订单已审核未送达的订单信息", notes = "获取所有采购订单已审核未送达的订单信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String receiveInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model) {
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = receiveInfoService.getReceiveInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/receiveInfo.jsp";
	}

	@RequestMapping("/receiveDetailInfo.do")
	@ApiOperation(value = "获取订单详细信息", notes = "获取传入的plan_id对应的额订单的详细信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "选择的订单的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String receiveDetailInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Long plan_id, Model model) {
		if (plan_id != null) {
			save_plan_id = plan_id;
		}
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = getDetailPlanInfoService.selectDeatilPlanInfo(save_plan_id, pageNum,
				pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/receiveDetailInfo.jsp";
	}

	@RequestMapping("/setPlanReceive.do")
	@ApiOperation(value = "设置订单为已接收", notes = "设置订单为已接收", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "选择的订单的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String setPlanReceive(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Long plan_id, Model model) {
		receiveInfoService.setPlanReceive(plan_id);
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = receiveInfoService.getReceiveInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/receiveInfo.jsp";
	}

	@RequestMapping("/jumpReceiveModify.do")
	@ApiOperation(value = "跳转到修改原料信息页面", notes = "跳转到修改原料信息页面", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "plan_id", value = "当前的订单的ID", dataType = "Long"),
			@ApiImplicitParam(name = "food_id", value = "选择的原料的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String jumpReceiveModify(Long plan_id, Long food_id, Model model) {
		String name = checkPlanService.getFoodName(food_id);
		int num = checkPlanService.getFoodNum(food_id);
		float price = checkPlanService.getFoodPrice(food_id);
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("price", price);
		model.addAttribute("plan_food_id", food_id);
		model.addAttribute("plan_id", plan_id);
		return "admin/bill/receiveModifyPlan.jsp";
	}

	@RequestMapping(value = "/receiveModifyPlan.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ApiOperation(value = "根据实际到货数量和单价修改原料信息", notes = "根据实际到货数量和单价即传入的num和price修改原料信息", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "name", value = "原料名称", dataType = "String"),
			@ApiImplicitParam(name = "num", value = "原料数量", dataType = "int"),
			@ApiImplicitParam(name = "price", value = "原料单价", dataType = "float"),
			@ApiImplicitParam(name = "plan_id", value = "选择的订单的ID", dataType = "Long"),
			@ApiImplicitParam(name = "food_id", value = "选择的原料的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String receiveModifyPlan(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, String name, int num, float price,
			Long plan_id, Long food_id, Model model) {
		checkPlanService.updateFoodNum(num, food_id);
		checkPlanService.updateFoodPrice(price, food_id);
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = getDetailPlanInfoService.selectDeatilPlanInfo(plan_id, pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/receiveDetailInfo.jsp";
	}

}
