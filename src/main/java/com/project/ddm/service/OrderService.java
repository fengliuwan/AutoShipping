package com.project.ddm.service;

import com.project.ddm.exception.OrderNotExistException;
import com.project.ddm.model.Order;
import com.project.ddm.model.User;
import com.project.ddm.repository.AuthorityRepository;
import com.project.ddm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {

    private UserRepository userRepository;

    @Autowired
    public OrderService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Order> findByUser(String username) throws OrderNotExistException {
        User user =  userRepository.findByUsername(username);
        List<Order> orders = user.getOrders();
        if (orders.isEmpty()) {
            throw new OrderNotExistException("History orders doesn't exist.");
        }
        return orders;
    }
}