package com.trxDemo.trxdemo.service;

import java.util.List;
import java.util.Map;

public interface FirstService {

	List<Map<String, Object>> queryItemList();

	int resetItemTable();

	public int updateItem1();

	public int updateItem1withTRX();

	public int updateItem1_ex() throws Exception;

	public int updateItem1withTRX_ex() throws Exception;

	public int updateItem2();

	public int updateItem2withTRX();

	public int updateItem2_ex() throws Exception;

	public int updateItem2withTRX_ex() throws Exception;

	/**
	 * @throws Exception 
	 * @Transactional 
	 * |AClass.method1| --> |BClass.method1|
	 */
	void runCase1() throws Exception;

	/** 
	 * @throws Exception 
	 *                       @Transactional
	 * |AClass.method1| --> |BClass.method1|
	 */
	void runCase2() throws Exception;
	
	
	/** 
	 * @throws Exception 
	 * @Transactional                      
	 * |AClass.method1| --> |AClass.method2|
	 */
	void runCase3() throws Exception;

	/** 
	 * @throws Exception 
	 *                      @Transactional 
	 * |AClass.method1| --> |AClass.method2|
	 */
	void runCase4() throws Exception;

}
