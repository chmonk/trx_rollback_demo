package com.trxDemo.trxdemo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trxDemo.trxdemo.repository.ItemRepository;

@Service
public class FirstServiceImpl implements FirstService {

	@Autowired
	ItemRepository rep;

	@Autowired
	SecondService secSer;

	@Override
	public List<Map<String, Object>> queryItemList() {
		return rep.queryItemList();
	}

	@Override
	public int resetItemTable() {

		boolean tableExist = true;

		try {
			rep.queryItemList();

			tableExist = true;
		} catch (Exception e) {
			rep.buildItmeTable();

			tableExist = false;
		}

		if (tableExist) {
			rep.cleanItemTable();
			rep.buildItmeTable();
		}

		return Arrays.stream(rep.buildDefaultItemInfo())
				.boxed()
				.reduce((a, b) -> a + b)
				.orElse(0);

	}

	@Override
	public int updateItem1() {
		int count = rep.service1UpdateItem1();
		return count;
	}

	@Override
	@Transactional
	public int updateItem1withTRX() {
		int count = rep.service1UpdateItem1();
		return count;
	}

	@Override
	public int updateItem2() {
		int count = rep.service1UpdateItem2();
		return count;
	}

	@Override
	@Transactional
	public int updateItem2withTRX() {
		int count = rep.service1UpdateItem2();
		return count;
	}

	@Override
	public int updateItem1_ex() throws Exception {
		int count = rep.service1UpdateItem1();
		throw new RuntimeException("");
	}

	@Override
	@Transactional
	public int updateItem1withTRX_ex() throws Exception {
		int count = rep.service1UpdateItem1();
		throw new Exception();
	}

	@Override
	public int updateItem2_ex() throws Exception {
		int count = rep.service1UpdateItem2();
		throw new RuntimeException("");
	}

	@Override
	@Transactional
	public int updateItem2withTRX_ex() throws Exception {
		int count = rep.service1UpdateItem2();
		throw new RuntimeException("");
	}

	/** 
	 * @throws Exception 
	 * @Transactional
	 * |AClass.method1| --> |BClass.method1|
	 */
	@Override
	@Transactional
	public void runCase1() throws Exception {
		updateItem1withTRX();
		secSer.updateItem2_ex();
	}

	/** 
	 * @throws Exception 
	 *                       @Transactional
	 * |AClass.method1| --> |BClass.method1|
	 */
	@Override
	public void runCase2() throws Exception {
		updateItem1();
		secSer.updateItem2withTRX_ex();
	}

	/** 
	 * @throws Exception 
	 * @Transactional                      
	 * |AClass.method1| --> |AClass.method2|
	 */
	@Override
	@Transactional
	public void runCase3() throws Exception {
		updateItem1();
		updateItem2_ex();
	}
	
	
	/** 
	 * @throws Exception 
	 *                      @Transactional 
	 * |AClass.method1| --> |AClass.method2|
	 */
	@Override
	public void runCase4() throws Exception {
		updateItem1();
		updateItem2withTRX_ex();
	}

}
