package com.shop.dao.repository;

import com.shop.dao.OrderDao;
import com.shop.models.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository implements OrderDao {

	@Override
	public void addOrder(Order order) {

	}
}
