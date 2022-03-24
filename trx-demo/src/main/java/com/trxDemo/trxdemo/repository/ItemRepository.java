package com.trxDemo.trxdemo.repository;

import java.util.List;
import java.util.Map;

public interface ItemRepository {

	public List<Map<String, Object>> queryItemList();

	public int service1UpdateItem1();

	public int service1UpdateItem2();
	
	public int service2UpdateItem1();

	public int service2UpdateItem2();

	public int cleanItemTable();

	public int buildItmeTable();

	public int[] buildDefaultItemInfo();

}
