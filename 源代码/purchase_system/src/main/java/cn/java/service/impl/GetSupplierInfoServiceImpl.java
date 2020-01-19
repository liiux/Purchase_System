package cn.java.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.java.mapper.GetSupplierInfoMapper;
import cn.java.service.GetSupplierInfoService;

@Service
public class GetSupplierInfoServiceImpl implements GetSupplierInfoService {

	@Autowired
	private GetSupplierInfoMapper getSupplierInfoMapper;

	@Override
	public List<Map<String, Object>> selectAllSupplierInfo(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return getSupplierInfoMapper.getAllSupplierInfo();
	}

	@Override
	public List<Map<String, Object>> selectSupplierInfoByCondition(Integer pageNum, Integer pageSize, String type,
			String keyWord) {
		PageHelper.startPage(pageNum, pageSize);
		return getSupplierInfoMapper.getSupplierInfoByCondition(type, keyWord);
	}

	@Override
	public boolean delSupplierInfo(Long id) {
		int flag = getSupplierInfoMapper.delSupplierInfo(id);
		return flag >= 1 ? true : false;
	}

	@Override
	public boolean batchDel(String idAttr) {
		idAttr = idAttr.substring(0, idAttr.length() - 1);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("idAttr", idAttr);
		int flag = getSupplierInfoMapper.batchDel(paramMap);
		return flag >= 1 ? true : false;
	}

}
