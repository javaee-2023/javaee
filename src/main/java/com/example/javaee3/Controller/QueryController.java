package com.example.javaee3.Controller;


import com.example.javaee3.Entity.Player;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("query")
public class QueryController {

    Player player = new Player();//
    //破纪录列表查询
    @GetMapping("record")
    public List<Player> recordQuery(String sport){

        List<Player> list = new ArrayList<>();
//        for() {
//            if (player.getSport().equals(sport))
//
//                if (player.getResult() > ) {
//                    list.add(player);
//                }
//        }
        return list;
    }

    List<Player> playersList=new ArrayList<>();//
    //个人成绩查询
    @PostMapping("record")
    public List<Player> playerRecordQuery(@RequestBody Player player){
        List<Player> list = new ArrayList<>();
        for(int i=0;i<= playersList.size()-1;++i){
            //筛选id
            if(!player.getId().equals("")){
                if(!playersList.get(i).getId().equals(player.getId())){
                    continue;
                }
            }
            //筛选name
            if(!player.getName().equals("")){
                if(!playersList.get(i).getName().equals(player.getName())){
                    continue;
                }
            }
            //筛选group
            if(!player.getGroup().equals("")){
                if(!playersList.get(i).getGroup().equals(player.getGroup())){
                    continue;
                }
            }
            //如果满足条件
            list.add(playersList.get(i));
        }
        return list;
    }

}
