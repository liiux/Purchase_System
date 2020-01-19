package cn.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

public interface ReceiveInfoMapper {

	List<Map<String, Object>> getReceiveInfo();

	@Update("UPDATE plan SET is_receive='1' WHERE id=#{plan_id}")
	int setPlanReceive(Long plan_id);
}
