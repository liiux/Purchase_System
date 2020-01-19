package cn.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.java.mapper.GetDetailPlanInfoMapper;
import cn.java.service.GetDetailPlanInfoService;

@Service
public class GetDetailPlanInfoServiceImpl implements GetDetailPlanInfoService {

	@Autowired
	private GetDetailPlanInfoMapper getDetailPlanInfoMapper;

	@Override
	public List<Map<String, Object>> selectDeatilPlanInfo(Long plan_id, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return getDetailPlanInfoMapper.getDetailPlanInfo(plan_id);
	}

}
