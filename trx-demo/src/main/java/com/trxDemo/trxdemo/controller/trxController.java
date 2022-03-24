package com.trxDemo.trxdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trxDemo.trxdemo.service.FirstService;
import com.trxDemo.trxdemo.service.SecondService;

@RestController
public class trxController {

	@Autowired
	FirstService ser1;

	@Autowired
	SecondService ser2;

	@GetMapping("/")
	public List<Map<String, Object>> getItemList() {
		return ser1.queryItemList();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	@GetMapping("/resetDBData")
	public List<Map<String, Object>> resetDBData() {
		try {
			ser1.resetItemTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ser1.queryItemList();
	}

	/**
	 * 	 @TRANSACTIONAL
	 *   |ACLASS.METhod1| --> |BClass.method1|
	 * @return
	 */
	@GetMapping("/case1")
	public List<Map<String, Object>> case1() {

		ser1.resetItemTable();

		try {
			ser1.runCase1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ser1.queryItemList();
	}

	/** 
	 * @throws Exception 
	 *                       @Transactional
	 * |AClass.method1| --> |BClass.method1|
	 */
	@GetMapping("/case2")
	public List<Map<String, Object>> case2() {

		ser1.resetItemTable();

		try {
			ser1.runCase2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ser1.queryItemList();
	}
	
	/** 
	 * @throws Exception 
	 * @Transactional                      
	 * |AClass.method1| --> |AClass.method2|
	 */
	@GetMapping("/case3")
	public List<Map<String, Object>> case3() {

		ser1.resetItemTable();

		try {
			ser1.runCase3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ser1.queryItemList();
	}
	
	/**
	 * @throws Exception 
	 *                      @Transactional 
	 * |AClass.method1| --> |AClass.method2|
	 */
	@GetMapping("/case4")
	public List<Map<String, Object>> case4() {

		ser1.resetItemTable();

		try {
			ser1.runCase4();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ser1.queryItemList();
	}

}
