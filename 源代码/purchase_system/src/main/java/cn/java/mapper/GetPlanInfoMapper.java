package cn.java.mapper;

import java.util.List;
import java.util.Map;

public interface GetPlanInfoMapper {

	List<Map<String, Object>> getAllPlanInfo(Long user_id);

}
