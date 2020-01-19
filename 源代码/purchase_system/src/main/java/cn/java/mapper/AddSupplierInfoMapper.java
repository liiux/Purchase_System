package cn.java.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AddSupplierInfoMapper {

	@Insert("INSERT INTO supplier(name,address,linkman,phone) VALUES(#{name},#{address},#{linkman},#{phone})")
	int addSupplierInfo(String name, String address, String linkman, String phone);

}
