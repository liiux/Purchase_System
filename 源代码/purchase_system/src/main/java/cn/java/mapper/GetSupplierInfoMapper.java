package cn.java.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

public interface GetSupplierInfoMapper {

	List<Map<String, Object>> getAllSupplierInfo();

	List<Map<String, Object>> getSupplierInfoByCondition(String type, String keyWord);

	@Update("UPDATE supplier SET status='0' WHERE id=#{id}")
	int delSupplierInfo(Long id);

	@Update("UPDATE supplier SET status='0' WHERE id IN (${idAttr})")
	int batchDel(Map<String, Object> paramMap);
}
