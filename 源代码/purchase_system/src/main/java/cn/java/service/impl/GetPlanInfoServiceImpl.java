package cn.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.java.mapper.GetPlanInfoMapper;
import cn.java.service.GetPlanInfoService;

@Service
public class GetPlanInfoServiceImpl implements GetPlanInfoService {

	@Autowired
	private GetPlanInfoMapper getPlanInfoMapper;

	@Override
	public List<Map<String, Object>> selectAllPlanInfo(Long user_id, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return getPlanInfoMapper.getAllPlanInfo(user_id);
	}

}
