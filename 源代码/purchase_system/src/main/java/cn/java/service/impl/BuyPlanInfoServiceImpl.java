package cn.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.java.mapper.BuyPlanInfoMapper;
import cn.java.service.BuyPlanInfoService;

@Service
public class BuyPlanInfoServiceImpl implements BuyPlanInfoService {

	@Autowired
	private BuyPlanInfoMapper buyPlanInfoMapper;

	@Override
	public List<Map<String, Object>> getPlanInfo(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return buyPlanInfoMapper.getBuyPlanInfo();
	}

	@Override
	public List<Map<String, Object>> getAllSupplier() {
		return buyPlanInfoMapper.getAllSupplier();
	}

	@Override
	public boolean setSupplier(Long supplier_id, Long plan_id) {
		int flag = buyPlanInfoMapper.setSupplier(supplier_id, plan_id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean setBuy(Long plan_id) {
		int flag = buyPlanInfoMapper.setBuy(plan_id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean setBuyDate(String buy_date, Long plan_id) {
		int flag = buyPlanInfoMapper.setBuyDate(buy_date, plan_id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean setBuyer(Long buyer_id, Long plan_id) {
		int flag = buyPlanInfoMapper.setBuyer(buyer_id, plan_id);
		return flag >= 1 ? true : false;
	}

	@Override
	public List<Map<String, Object>> getMyPlanInfo(Long buyer_id, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return buyPlanInfoMapper.getMyBuyPlanInfo(buyer_id);
	}

}
