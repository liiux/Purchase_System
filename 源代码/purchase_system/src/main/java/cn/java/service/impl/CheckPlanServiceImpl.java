package cn.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.java.mapper.CheckPlanMapper;
import cn.java.service.CheckPlanService;

@Service
public class CheckPlanServiceImpl implements CheckPlanService {

	@Autowired
	private CheckPlanMapper checkPlanMapper;

	@Override
	public List<Map<String, Object>> getPlanInfo(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return checkPlanMapper.getPlanInfo();
	}

	@Override
	public String getFoodName(Long id) {
		return checkPlanMapper.getFoodName(id);
	}

	@Override
	public int getFoodNum(Long id) {
		return checkPlanMapper.getFoodNum(id);
	}

	@Override
	public float getFoodPrice(Long id) {
		return checkPlanMapper.getFoodPrice(id);
	}

	@Override
	public boolean updateFoodName(String name, Long id) {
		int flag = checkPlanMapper.updateFoodName(name, id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean updateFoodNum(int num, Long id) {
		int flag = checkPlanMapper.updateFoodNum(num, id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean updateFoodPrice(float price, Long id) {
		int flag = checkPlanMapper.updateFoodPrice(price, id);
		return flag >= 1 ? true : false;
	}

	@Override
	public List<Map<String, Object>> getBuyPlanInfo(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return checkPlanMapper.getBuyPlanInfo();
	}

	@Override
	public Long getSupplierId(Long plan_id) {
		return checkPlanMapper.getSupplierId(plan_id);
	}

	@Override
	public String getSupplierName(Long supplier_id) {
		return checkPlanMapper.getSupplierName(supplier_id);
	}

	@Override
	public boolean updateSupplier(Long plan_id, Long supplier_id) {
		int flag = checkPlanMapper.updateSupplier(plan_id, supplier_id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean delPlanFood(Long food_id, Long plan_id) {
		int flag = checkPlanMapper.delPlanFood(food_id, plan_id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean setPlanCheck(Long plan_id) {
		int flag = checkPlanMapper.setPlanCheck(plan_id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean setOrderCheck(Long plan_id) {
		int flag = checkPlanMapper.setOrderCheck(plan_id);
		return flag >= 1 ? true : false;
	}
}
