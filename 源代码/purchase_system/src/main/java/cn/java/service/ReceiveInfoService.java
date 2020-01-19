package cn.java.service;

import java.util.List;
import java.util.Map;

public interface ReceiveInfoService {

	List<Map<String, Object>> getReceiveInfo(Integer pageNum, Integer pageSize);

	boolean setPlanReceive(Long plan_id);
}