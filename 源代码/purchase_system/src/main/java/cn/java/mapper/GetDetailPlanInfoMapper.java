package cn.java.mapper;

import java.util.List;
import java.util.Map;

public interface GetDetailPlanInfoMapper {

	List<Map<String, Object>> getDetailPlanInfo(Long plan_id);

}
