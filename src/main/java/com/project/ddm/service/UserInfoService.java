package com.project.ddm.service;

import com.project.ddm.exception.OrderNotExistException;
import com.project.ddm.model.Order;
import com.project.ddm.model.User;
import com.project.ddm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserInfoService {

    private UserRepository userRepository;

    @Autowired
    public UserInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserInformation(String username){
        return userRepository.findByUsername(username);
    }
    public List<Order> findUserHistoryOrders(String username) throws OrderNotExistException {
        User user =  userRepository.findByUsername(username);
        List<Order> orders = user.getOrders();
        if (orders.isEmpty()) {
            throw new OrderNotExistException("History orders doesn't exist.");
        }
        return orders;
    }
}