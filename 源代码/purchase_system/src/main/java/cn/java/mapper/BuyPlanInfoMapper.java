package cn.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BuyPlanInfoMapper {

	List<Map<String, Object>> getBuyPlanInfo();

	@Select("SELECT id,name FROM supplier WHERE status='1'")
	List<Map<String, Object>> getAllSupplier();

	@Update("UPDATE plan SET supplier_id=#{supplier_id} WHERE id=#{plan_id}")
	int setSupplier(Long supplier_id, Long plan_id);

	@Update("UPDATE plan SET is_buy='1' WHERE id=#{plan_id}")
	int setBuy(Long plan_id);

	@Update("UPDATE plan SET buy_date=#{buy_date} WHERE id=#{plan_id}")
	int setBuyDate(String buy_date, Long plan_id);

	@Update("UPDATE plan SET buyer_id=#{buyer_id} WHERE id=#{plan_id}")
	int setBuyer(Long buyer_id, Long plan_id);

	List<Map<String, Object>> getMyBuyPlanInfo(Long buyer_id);
}
