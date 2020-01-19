package cn.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.java.service.AddSupplierInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "添加供应商", tags = "添加供应商")
public class AddSupplierInfoController {

	@Autowired
	private AddSupplierInfoService addSupplierInfoService;

	@RequestMapping("/addSupplierInfo_main.do")
	@ApiOperation(value = "跳转到添加供应商界面", notes = "跳转到添加供应商界面", httpMethod = "POST", response = String.class)
	public String addSupplierInfo_main() {
		return "admin/bill/addSupplierInfo.jsp";
	}

	@RequestMapping("/addSupplierInfo.do")
	@ApiOperation(value = "添加供应商", notes = "通过传入的名称、地址、联系人姓名、联系电话insert一个供应商", httpMethod = "POST", response = String.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "供应商名称", dataType = "String"),
			@ApiImplicitParam(name = "address", value = "供应商地址", dataType = "String"),
			@ApiImplicitParam(name = "linkman", value = "联系人姓名", dataType = "String"),
			@ApiImplicitParam(name = "phone", value = "联系电话", dataType = "String"), })
	public String addSupplierInfo(String name, String address, String linkman, String phone) {
		addSupplierInfoService.addSupplierInfo(name, address, linkman, phone);
		return "admin/bill/addSupplierInfo.jsp";
	}

}
