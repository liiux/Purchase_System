package cn.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.java.service.AddPlanInfoService;
import cn.java.service.BuyPlanInfoService;
import cn.java.service.CheckPlanService;
import cn.java.service.GetDetailPlanInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "采购主管", tags = "采购主管管理")
public class CheckPlanController {

	@Autowired
	private CheckPlanService checkPlanService;

	@Autowired
	private GetDetailPlanInfoService getDetailPlanInfoService;

	@Autowired
	private AddPlanInfoService addPlanInfoService;

	@Autowired
	private BuyPlanInfoService buyPlanInfoService;

	private Long save_plan_id;

	@RequestMapping("/checkPlanInfo.do")
	@ApiOperation(value = "获取所有待审核采购计划的信息", notes = "获取所有待审核采购计划的信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String checkPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model) {
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = checkPlanService.getPlanInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/checkPlanInfo.jsp";
	}

	@RequestMapping("/setPlanCheck.do")
	@ApiOperation(value = "设置采购计划为已审核", notes = "设置传入的plan_id对应的采购计划为已审核", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "选择的采购计划的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String setPlanCheck(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Long plan_id, Model model) {
		checkPlanService.setPlanCheck(plan_id);
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = checkPlanService.getPlanInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/checkPlanInfo.jsp";
	}

	@RequestMapping("/checkDetailPlanInfo.do")
	@ApiOperation(value = "获取采购计划详细信息", notes = "获取传入的plan_id对应的采购计划的详细信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "选择的采购计划的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String checkDetailPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
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
		model.addAttribute("plan_id", plan_id);
		return "admin/bill/checkDetailPlanInfo.jsp";
	}

	@RequestMapping("/modifyPlanInfo.do")
	@ApiOperation(value = "初始化修改原料信息页面", notes = "根据传入的food_id查询对应的name，num，price信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "plan_id", value = "选择的采购计划的ID", dataType = "Long"),
			@ApiImplicitParam(name = "food_id", value = "选择的原料的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String modifyPlanInfo(Long plan_id, Long food_id, Model model) {
		String name = checkPlanService.getFoodName(food_id);
		int num = checkPlanService.getFoodNum(food_id);
		float price = checkPlanService.getFoodPrice(food_id);
		model.addAttribute("plan_id", plan_id);
		model.addAttribute("plan_food_id", food_id);
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		model.addAttribute("price", price);
		return "admin/bill/modifyPlanInfo.jsp";
	}

	@RequestMapping(value = "/setModiftPlanInfo.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ApiOperation(value = "修改原料信息", notes = "根据传入的name,num,price更新对应food_id的信息", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "name", value = "原料名称", dataType = "Integer"),
			@ApiImplicitParam(name = "num", value = "原料数量", dataType = "Integer"),
			@ApiImplicitParam(name = "price", value = "原料单价", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "选择的采购计划的ID", dataType = "Long"),
			@ApiImplicitParam(name = "food_id", value = "选择的原料的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String setModiftPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, String name, int num, float price,
			Long plan_id, Long food_id, Model model) {
		checkPlanService.updateFoodName(name, food_id);
		checkPlanService.updateFoodNum(num, food_id);
		checkPlanService.updateFoodPrice(price, food_id);
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = getDetailPlanInfoService.selectDeatilPlanInfo(plan_id, pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("plan_id", plan_id);
		return "admin/bill/checkDetailPlanInfo.jsp";
	}

	@RequestMapping("/jumpAddPlanInfo.do")
	@ApiOperation(value = "跳转到添加原料页面", notes = "跳转到添加原料页面", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "plan_id", value = "当前采购计划的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String jumpAddPlanInfo(Long plan_id, Model model) {
		model.addAttribute("plan_id", plan_id);
		return "admin/bill/checkAddPlanInfo.jsp";
	}

	@RequestMapping(value = "/checkAddPlanInfo.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ApiOperation(value = "添加原料", notes = "根据传入的name,num,price，insert一个原料，再将其添加到plan_id对应的采购计划中", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "name", value = "原料名称", dataType = "Integer"),
			@ApiImplicitParam(name = "num", value = "原料数量", dataType = "Integer"),
			@ApiImplicitParam(name = "price", value = "原料单价", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "当前采购计划的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String checkAddPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, String name, int num, float price,
			Long plan_id, Model model) {
		boolean flag = addPlanInfoService.addPlanInfo(name, num, price);
		if (flag) {
			Long maxFood = addPlanInfoService.getMaxFood();
			addPlanInfoService.addFoodPlan(plan_id, maxFood);
			// 分页之后返回的数据
			List<Map<String, Object>> infoList = getDetailPlanInfoService.selectDeatilPlanInfo(plan_id, pageNum,
					pageSize);
			// 将infoList封装到PageInfo工具类中
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("plan_id", plan_id);
			return "admin/bill/checkDetailPlanInfo.jsp";
		} else {
			model.addAttribute("plan_id", plan_id);
			return "admin/bill/checkAddPlanInfo.jsp";
		}
	}

	@RequestMapping("/checkBuyPlanInfo.do")
	@ApiOperation(value = "获取待审核的采购计划的信息", notes = "获取待审核的采购计划的信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String checkBuyPlanInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model) {
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = checkPlanService.getBuyPlanInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/checkBuyPlanInfo.jsp";
	}

	@RequestMapping("/jumpModifySupplier.do")
	@ApiOperation(value = "跳转到修改供应商的页面", notes = "跳转到修改供应商的页面", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "plan_id", value = "当前采购订单的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String jumpModifySupplier(Long plan_id, Model model) {
		List<Map<String, Object>> supplierInfo = buyPlanInfoService.getAllSupplier();
		Long supplier_id = checkPlanService.getSupplierId(plan_id);
		String supplier_name = checkPlanService.getSupplierName(supplier_id);
		model.addAttribute("supplierInfo", supplierInfo);
		model.addAttribute("plan_id", plan_id);
		model.addAttribute("supplier_id", supplier_id);
		model.addAttribute("supplier_name", supplier_name);
		return "admin/bill/modifySupplier.jsp";
	}

	@RequestMapping(value = "/modifySupplier.do", method = { RequestMethod.POST, RequestMethod.GET })
	@ApiOperation(value = "修改供应商", notes = "根据传入的supplier_info提取出供应商的ID，更新plan_id对应的采购订单的供应商", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "supplier_info", value = "选择的供应商信息", dataType = "String"),
			@ApiImplicitParam(name = "plan_id", value = "当前采购订单的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String modifySupplier(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, String supplier_info, Long plan_id,
			Model model) {
		String[] si = supplier_info.split("——");
		Long supplier_id = Long.valueOf(si[0]);
		boolean flag = checkPlanService.updateSupplier(plan_id, supplier_id);
		if (flag) {
			// 分页之后返回的数据
			List<Map<String, Object>> infoList = checkPlanService.getBuyPlanInfo(pageNum, pageSize);
			// 将infoList封装到PageInfo工具类中
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
			model.addAttribute("pageInfo", pageInfo);
			return "admin/bill/checkBuyPlanInfo.jsp";
		} else {

		}
		return null;
	}

	@RequestMapping("/delPlanInfo.do")
	@ApiOperation(value = "删除采购计划中的原料", notes = "根据传入的foodId和planId删除这一条数据", httpMethod = "POST", response = boolean.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "foodId", value = "选择的原料的ID", dataType = "Long"),
			@ApiImplicitParam(name = "planId", value = "当前订单的ID", dataType = "Long"), })
	public @ResponseBody boolean delPlanInfo(Long foodId, Long planId) {
		return checkPlanService.delPlanFood(foodId, planId);
	}

	@RequestMapping("/setOrderCheck.do")
	@ApiOperation(value = "设置采购订单为已审核", notes = "设置传入的plan_id对应的采购订单为已审核", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "plan_id", value = "选择的采购订单的ID", dataType = "Long"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String setOrderCheck(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Long plan_id, Model model) {
		boolean flag = checkPlanService.setOrderCheck(plan_id);
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = checkPlanService.getBuyPlanInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/checkBuyPlanInfo.jsp";
	}

}
