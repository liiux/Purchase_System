package cn.java.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CheckPlanService {

	List<Map<String, Object>> getPlanInfo(Integer pageNum, Integer pageSize);

	String getFoodName(Long id);

	int getFoodNum(Long id);

	float getFoodPrice(Long id);

	boolean updateFoodName(String name, Long id);

	boolean updateFoodNum(int num, Long id);

	boolean updateFoodPrice(float price, Long id);

	List<Map<String, Object>> getBuyPlanInfo(Integer pageNum, Integer pageSize);

	Long getSupplierId(Long plan_id);

	String getSupplierName(Long supplier_id);

	boolean updateSupplier(Long plan_id, Long supplier_id);

	boolean delPlanFood(Long food_id, Long plan_id);

	boolean setPlanCheck(Long plan_id);

	boolean setOrderCheck(Long plan_id);
}