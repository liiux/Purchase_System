package cn.java.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface AddPlanInfoMapper {

	@Insert("INSERT INTO plan(plan_date,planer_id) VALUES(#{date},#{user_id})")
	int addPlan(String date, Long user_id);

	@Select("SELECT max(id) As maxPlan FROM plan")
	Long getMaxPlan();

	@Insert("INSERT INTO food(name,num,price) VALUES(#{name},#{num},#{price})")
	int addPlanInfo(String name, int num, float price);

	@Select("SELECT max(id) AS maxFood FROM food")
	Long getMaxFood();

	@Insert("INSERT INTO food_plan(plan_id,plan_food_id) VALUES(#{plan_id},#{plan_food_id})")
	int addFoodPlan(Long plan_id, Long plan_food_id);
}
