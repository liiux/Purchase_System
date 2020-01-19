package cn.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.java.mapper.AddSupplierInfoMapper;
import cn.java.service.AddSupplierInfoService;

@Service
public class AddSupplierInfoServiceImpl implements AddSupplierInfoService {

	@Autowired
	private AddSupplierInfoMapper addSupplierInfoMapper;

	@Override
	public boolean addSupplierInfo(String name, String address, String linkman, String phone) {
		int flag = addSupplierInfoMapper.addSupplierInfo(name, address, linkman, phone);
		return flag >= 1 ? true : false;
	}

}
