package cn.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.mapper.AddPlanInfoMapper;
import cn.java.service.AddPlanInfoService;

@Service
public class AddPlanInfoServiceImpl implements AddPlanInfoService {

	@Autowired
	private AddPlanInfoMapper addPlanInfoMapper;

	@Override
	public boolean addPlan(String date, Long user_id) {
		int flag = addPlanInfoMapper.addPlan(date, user_id);
		return flag >= 1 ? true : false;
	}

	@Override
	public Long getMaxPlan() {
		return addPlanInfoMapper.getMaxPlan();
	}

	@Override
	public boolean addPlanInfo(String name, int num, float price) {
		int flag = addPlanInfoMapper.addPlanInfo(name, num, price);
		return flag >= 1 ? true : false;
	}

	@Override
	public Long getMaxFood() {
		return addPlanInfoMapper.getMaxFood();
	}

	@Override
	public boolean addFoodPlan(Long plan_id, Long plan_food_id) {
		int flag = addPlanInfoMapper.addFoodPlan(plan_id, plan_food_id);
		return flag >= 1 ? true : false;
	}

}
