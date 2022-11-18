package com.example.chatdemo.page.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class PageController {

    static HashMap<String,String> idList=new HashMap<>();

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/goMain")
    public String main(HttpSession session, String nickName){

        if(nickName==null){
            return "index";
        }

        if(idList.get(nickName)!=null){
            return "index";
        }
        session.setAttribute("nickName",nickName);

        return "main";
    }
}
