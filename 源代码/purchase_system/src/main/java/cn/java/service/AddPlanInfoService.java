package cn.java.service;

public interface AddPlanInfoService {

	boolean addPlan(String date, Long user_id);

	Long getMaxPlan();

	boolean addPlanInfo(String name, int num, float price);

	Long getMaxFood();

	boolean addFoodPlan(Long plan_id, Long plan_food_id);
}