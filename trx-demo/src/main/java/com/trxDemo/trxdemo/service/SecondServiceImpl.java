package com.trxDemo.trxdemo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trxDemo.trxdemo.repository.ItemRepository;


@Service
public class SecondServiceImpl implements SecondService {
	@Autowired
	ItemRepository rep;

	@Override
	public int updateItem2() {
		int count = rep.service2UpdateItem2();
		return count;
	}

	@Override
	public int updateItem2_ex() throws Exception {
		int count = rep.service2UpdateItem2();
		throw new RuntimeException("");
	}

	@Override
	@Transactional
	public int updateItem2withTRX() {
		int count = rep.service2UpdateItem2();
		return count;
	}

	@Override
	@Transactional
	public int updateItem2withTRX_ex() throws Exception {
		int count = rep.service2UpdateItem2();
		throw new RuntimeException("");
	}

}
