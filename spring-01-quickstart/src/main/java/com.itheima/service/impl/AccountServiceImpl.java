package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    public void register(){
        System.out.println("register is running...");
    }
}
