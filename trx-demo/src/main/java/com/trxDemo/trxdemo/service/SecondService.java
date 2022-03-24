package com.trxDemo.trxdemo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface SecondService {

	public int updateItem2withTRX();

	public int updateItem2withTRX_ex() throws Exception;

	public int updateItem2();

	public int updateItem2_ex() throws Exception;
}
