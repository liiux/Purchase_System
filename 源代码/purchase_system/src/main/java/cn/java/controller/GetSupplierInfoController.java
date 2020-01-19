package cn.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.java.service.GetSupplierInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "获取供应商信息", tags = "获取供应商信息")
public class GetSupplierInfoController {

	private String save_type, save_keyWord;

	@Autowired
	private GetSupplierInfoService getSupplierInfoService;

	@RequestMapping("/getSupplierInfo.do")
	@ApiOperation(value = "获取所有供应商的信息", notes = "获取所有供应商的信息", httpMethod = "GET", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String getSupplierInfo(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model) {
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = getSupplierInfoService.selectAllSupplierInfo(pageNum, pageSize);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/getSupplierInfo.jsp";
	}

	@RequestMapping("/getSupplierInfoByCondition.do")
	@ApiOperation(value = "根据选择类型按关键字查找", notes = "根据选择类型按关键字查找", httpMethod = "POST", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageNum", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "pageSize", value = "分页所需", dataType = "Integer"),
			@ApiImplicitParam(name = "type", value = "选择的查找类型", dataType = "Integer"),
			@ApiImplicitParam(name = "keyWord", value = "输入的关键字", dataType = "Integer"),
			@ApiImplicitParam(name = "model", value = "传参所需", dataType = "Model"), })
	public String getSupplierInfoByCondition(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize, Model model, String type,
			String keyWord) {
		if (type != null && keyWord != null) {
			save_type = type;
			save_keyWord = keyWord;
		}
		// 分页之后返回的数据
		List<Map<String, Object>> infoList = getSupplierInfoService.selectSupplierInfoByCondition(pageNum, pageSize,
				save_type, save_keyWord);
		// 将infoList封装到PageInfo工具类中
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(infoList);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/bill/getSupplierInfoByCondition.jsp";
	}

	@RequestMapping("/delSupplierInfo.do")
	@ApiOperation(value = "删除供应商", notes = "删除传入的id对应的供应商", httpMethod = "POST", response = boolean.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "选择的供应商ID", dataType = "Long"), })
	public @ResponseBody boolean delSupplierInfo(Long id) {
		boolean flag = getSupplierInfoService.delSupplierInfo(id);
		return flag;
	}

	@RequestMapping("/batchDel.do")
	@ApiOperation(value = "批量删除供应商", notes = "删除传入的idAttr中对应的供应商", httpMethod = "POST", response = boolean.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "idAttr", value = "选择的供应商ID集合", dataType = "String"), })
	public @ResponseBody boolean batchDel(String idAttr) {
		return getSupplierInfoService.batchDel(idAttr);
	}
}
