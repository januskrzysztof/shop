package com.shop.services;

import com.shop.dao.OrderDao;
import com.shop.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;

	@Autowired
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void addOrder(Order order) {
		orderDao.addOrder(order);
	}
}
