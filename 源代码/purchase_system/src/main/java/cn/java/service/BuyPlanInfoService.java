package cn.java.service;

import java.util.List;
import java.util.Map;

public interface BuyPlanInfoService {

	List<Map<String, Object>> getPlanInfo(Integer pageNum, Integer pageSize);

	List<Map<String, Object>> getAllSupplier();

	boolean setSupplier(Long supplier_id, Long plan_id);

	boolean setBuy(Long plan_id);

	boolean setBuyDate(String buy_date, Long plan_id);

	boolean setBuyer(Long buyer_id, Long plan_id);

	List<Map<String, Object>> getMyPlanInfo(Long buyer_id, Integer pageNum, Integer pageSize);
}