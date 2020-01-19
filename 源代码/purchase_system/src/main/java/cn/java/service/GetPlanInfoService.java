package cn.java.service;

import java.util.List;
import java.util.Map;

public interface GetPlanInfoService {

	List<Map<String, Object>> selectAllPlanInfo(Long user_id, Integer pageNum, Integer pageSize);

}