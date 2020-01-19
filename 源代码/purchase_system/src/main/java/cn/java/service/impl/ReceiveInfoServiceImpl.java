package cn.java.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.java.mapper.ReceiveInfoMapper;
import cn.java.service.ReceiveInfoService;

@Service
public class ReceiveInfoServiceImpl implements ReceiveInfoService {

	@Autowired
	private ReceiveInfoMapper receiveInfoMapper;

	@Override
	public List<Map<String, Object>> getReceiveInfo(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return receiveInfoMapper.getReceiveInfo();
	}

	@Override
	public boolean setPlanReceive(Long plan_id) {
		int flag = receiveInfoMapper.setPlanReceive(plan_id);
		return flag >= 1 ? true : false;
	}

}
