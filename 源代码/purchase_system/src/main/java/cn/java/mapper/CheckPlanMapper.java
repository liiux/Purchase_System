package cn.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CheckPlanMapper {

	List<Map<String, Object>> getPlanInfo();

	@Select("SELECT name FROM food WHERE id=#{id}")
	String getFoodName(Long id);

	@Select("SELECT num FROM food WHERE id=#{id}")
	int getFoodNum(Long id);

	@Select("SELECT price FROM food WHERE id=#{id}")
	float getFoodPrice(Long id);

	@Update("UPDATE food SET name=#{name} WHERE id=#{id}")
	int updateFoodName(String name, Long id);

	@Update("UPDATE food SET num=#{num} WHERE id=#{id}")
	int updateFoodNum(int num, Long id);

	@Update("UPDATE food SET price=#{price} WHERE id=#{id}")
	int updateFoodPrice(float price, Long id);

	List<Map<String, Object>> getBuyPlanInfo();

	@Select("SELECT supplier_id FROM plan WHERE id=#{plan_id}")
	Long getSupplierId(Long plan_id);

	@Select("SELECT name FROM supplier WHERE id=#{supplier_id}")
	String getSupplierName(Long supplier_id);

	@Update("UPDATE plan SET supplier_id=#{supplier_id} WHERE id=#{plan_id}")
	int updateSupplier(Long plan_id, Long supplier_id);

	@Delete("DELETE FROM food_plan WHERE plan_id=#{plan_id} AND plan_food_id=#{food_id}")
	int delPlanFood(Long food_id, Long plan_id);

	@Update("UPDATE plan SET is_plan_check='1' WHERE id=#{plan_id}")
	int setPlanCheck(Long plan_id);

	@Update("UPDATE plan SET is_order_check='1' WHERE id=#{plan_id}")
	int setOrderCheck(Long plan_id);
}
