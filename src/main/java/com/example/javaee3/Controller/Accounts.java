package com.example.javaee3.Controller;

import com.example.javaee3.Enity.Account;
import com.example.javaee3.Util.GetAccounts;
import com.example.javaee3.Util.GetUsers;
import com.example.javaee3.Enity.Account;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("account")
public class Accounts {
    @PostMapping("isLogin")
    public Map isLogin(@RequestBody Account account){
        System.out.println(account.toString());
        Map map=new HashMap();
        List<Account> list= GetAccounts.getAccounts();
        for(int i=0;i<=list.size()-1;++i){
            //System.out.println("？？"+list.get(i).toString());
            if(Objects.equals(account.getUsername(), list.get(i).getUsername()) && Objects.equals(account.getPassword(), list.get(i).getPassword())){
                map.put("message", "登录成功");
                map.put("token", "123456");
                return map;
            }
        }
        map.put("message", "用户名或密码错误");
        return map;
    }
    @GetMapping("users")
    public Map getUsers(String query, int pageSize, int pageNum){
        Map map=new HashMap();
        map.put("message", "这是查找用户");
        //map.put("？？？","???")
        map.put("users", GetUsers.getUsers());
        return map;
    }
}
