package com.example.controller;
import com.example.dao.DoorMapper;
import com.example.pojo.Door;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DoorController {

    @Autowired
    private DoorMapper DoorMapper;
    /*Autowired自动装配更具当前变量的类型DoorMapper到spring容器中获取该接口对应的子类实例将接口的子类实力复制给doorMapper*/

    /*通用的页面跳转方法*/
    @RequestMapping("/{JspName}")
    public String toJSP(@PathVariable String JspName){
        return  JspName;
    }
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("/doorList")
    public String doorList(Model model){
        //调用DoorMapper的find方法查询所有的门店信息
        List<Door> list=DoorMapper.findAll();
        //将所有的门店信息存入Model中带到JSp去现实
        model.addAttribute("list",list);
        //跳转到门店列表页面
        return "door_list";
    }
    @RequestMapping("/top")
    public String top(){
        return "top";
    }
    @RequestMapping("/right")
    public String right(){
        return "right";
    }

//=================================
        @RequestMapping("/testmvc")
        public String testmvc(){
            System.out.println("springmvc的环境已经准备完毕！");
            return  "test";
        }
        @RequestMapping("/testssm")
    public String testssm(){
            System.out.println("DoorController.testssm()");
            List<Door> list =DoorMapper.findAll();
            for(Door test : list){
                System.out.println(test.toString());
            }
            return "test";
        }
}
