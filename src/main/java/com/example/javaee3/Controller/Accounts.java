package com.example.javaee3.Controller;

import com.example.javaee3.Entity.Account;
import com.example.javaee3.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *登录
 */

@RestController
@CrossOrigin
@RequestMapping("account")
public class Accounts {
    @Autowired
    AccountService accountService;
    @PostMapping("isLogin")
    public Map isLogin(@RequestBody Account account){
        System.out.println(account.toString());

        Map map=new HashMap();
        List<Account> list= accountService.getAllAccount();
        for(int i=0;i<=list.size()-1;++i){
            //System.out.println("？？"+list.get(i).toString());
            if(Objects.equals(account.getUsername(), list.get(i).getUsername()) && Objects.equals(account.getPassword(), list.get(i).getPassword())){
                map.put("message", "登录成功");
                map.put("token", "123456");
                map.put("code", 1);
                return map;
            }
        }
        map.put("code", -1);
        map.put("message", "用户名或密码错误");
        return map;
    }
}
