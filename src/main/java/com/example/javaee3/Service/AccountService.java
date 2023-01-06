package com.example.javaee3.Service;

import com.example.javaee3.Entity.Account;
import com.example.javaee3.Mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;
    //返回所有账号数据
    public List<Account> getAllAccount(){
        return accountMapper.findAll();
    }
}
