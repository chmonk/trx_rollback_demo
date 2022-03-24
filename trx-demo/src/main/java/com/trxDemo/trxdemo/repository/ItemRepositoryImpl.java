package com.trxDemo.trxdemo.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate jtemp;

	@Override
	public List<Map<String, Object>> queryItemList() {

		StringBuilder sbSql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();

		sbSql.append(" SELECT * FROM `Item` ");

		return jtemp.queryForList(sbSql.toString(), map);
	}

	@Override
	public int service1UpdateItem1() {

		StringBuilder sbSql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();

		sbSql.append(" UPDATE Item SET `price`=:price ,`describe`= :describe WHERE id=1; ");
		map.put("price", 20001);
		map.put("describe", "item 1 ,updated by ser1 item describe");

		return jtemp.update(sbSql.toString(), map);
	}

	@Override
	public int service1UpdateItem2() {

		StringBuilder sbSql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();

		sbSql.append(" UPDATE Item SET `price`=:price ,`describe`= :describe WHERE id=2; ");

		map.put("price", 30001);
		map.put("describe", "item 2 ,updated by ser1 item describe");

		return jtemp.update(sbSql.toString(), map);
	}

	@Override
	public int service2UpdateItem1() {

		StringBuilder sbSql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();

		sbSql.append(" UPDATE Item SET `price`=:price ,`describe`= :describe WHERE id=1; ");
		map.put("price", 20002);
		map.put("describe", "item 1 ,updated by ser2 item describe");

		return jtemp.update(sbSql.toString(), map);
	}

	@Override
	public int service2UpdateItem2() {
		StringBuilder sbSql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();

		sbSql.append(" UPDATE Item SET `price`=:price ,`describe`= :describe WHERE id=2; ");
		map.put("price", 30002);
		map.put("describe", "item 2 ,updated by ser2 item describe");

		return jtemp.update(sbSql.toString(), map);
	}

	@Override
	public int cleanItemTable() {

		StringBuilder sbSql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();

		sbSql.append(" Drop Table Item; ");
		return jtemp.update(sbSql.toString(), map);
	}

	@Override
	public int buildItmeTable() {
		StringBuilder sbSql = new StringBuilder();
		Map<String, Object> map = new HashMap<>();

		sbSql.append(" CREATE TABLE Item ( ");
		sbSql.append(" `id` int not null AUTO_INCREMENT, ");
		sbSql.append(" `price` int NOT NULL, ");
		sbSql.append(" `describe` varchar(60), ");
		sbSql.append(" primary key (`id`) ");
		sbSql.append(" ); ");

		return jtemp.update(sbSql.toString(), map);
	}

	@Override
	public int[] buildDefaultItemInfo() {
		StringBuilder sbSql = new StringBuilder();

		sbSql.append("INSERT INTO Item (`price` ,`describe`) values ( :price , :describe ) ; ");

		List<Map<String, Object>> q = new LinkedList<>();

		Map<String, Object> a = new HashMap<>();
		a.put("price", 20000);
		a.put("describe", "item 1 , origin item describe");
		Map<String, Object> b = new HashMap<>();
		b.put("price", 30000);
		b.put("describe", "item 2 , origin item describe");

		q.add(a);
		q.add(b);

		Map[] fin = new Map[q.size()];

		q.toArray(fin);

		return jtemp.batchUpdate(sbSql.toString(), fin);
	}

}
