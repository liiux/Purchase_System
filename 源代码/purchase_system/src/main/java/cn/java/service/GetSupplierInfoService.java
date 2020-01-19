package cn.java.service;

import java.util.List;
import java.util.Map;

public interface GetSupplierInfoService {

	/**
	 * 
	 * @param pageNum  当前页码
	 * @param pageSize 每页显示的数据量
	 * @return
	 */
	List<Map<String, Object>> selectAllSupplierInfo(Integer pageNum, Integer pageSize);

	List<Map<String, Object>> selectSupplierInfoByCondition(Integer pageNum, Integer pageSize, String type,
			String keyWord);

	boolean delSupplierInfo(Long id);

	boolean batchDel(String idAttr);
}