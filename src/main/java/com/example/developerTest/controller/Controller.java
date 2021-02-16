package com.example.developerTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller

public class Controller {

@RequestMapping("/home")
    public String homepage(){



    return "home.jsp";
}


}
