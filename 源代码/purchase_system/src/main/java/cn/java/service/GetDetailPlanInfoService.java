package cn.java.service;

import java.util.List;
import java.util.Map;

public interface GetDetailPlanInfoService {

	List<Map<String, Object>> selectDeatilPlanInfo(Long plan_id, Integer pageNum, Integer pageSize);

}