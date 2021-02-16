package com.example.developerTest.controller;

import com.example.developerTest.dao.Database;
import com.example.developerTest.model.ContactList;
import com.example.developerTest.model.Users;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller

public class Controller {
    Database database = new Database();
@RequestMapping("/home")
    public String homepage(){



    return "home.jsp";
}


@RequestMapping("/create")
public String create(){


    return "create.jsp";
}



@RequestMapping("/createUser")
public ModelAndView createUser(@RequestParam("username") String username, @RequestParam("password") String password){

    ModelAndView mv = new ModelAndView("home.jsp");

    Users newUser = new Users();

    newUser.setUsername(username);
    newUser.setPassword(password);

    database.addUser(newUser);
if(database.getErrorReport()==0) {
    mv.addObject("notify", "Congartulations " + username + ". You have been added and You may Login Now...");
}else if(database.getErrorReport()==1){
    mv.setViewName("create.jsp");
    mv.addObject("notify", "Sorry! Username " + username + " already exists please try another Username");

}
    return mv;
}




@RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password){
ModelAndView mv = new ModelAndView("book.jsp") ;

    database.readUserContacts(username, password);

    System.out.println(database.readUserContacts(username,password).get(0).getContacts().get(0).getPhoneNumber());

    mv.addObject("contactCode", generateContactList(database.readUserContacts(username, password).get(0)));


return mv;
    }


public String generateContactList(ContactList list){
 String HTMLCode="";

 for(int i=0; i< list.getContacts().size(); i++){

String firstName = list.getContacts().get(i).getFirstName();
String lastName = list.getContacts().get(i).getLastName();
String email = list.getContacts().get(i).getEmail();
String phoneNumber = list.getContacts().get(i).getPhoneNumber();


HTMLCode = HTMLCode + "<div class=\"w3-container  w3-black w3-round-large w3-center w3-card-4 w3-margin\">\n" +
        "  <img src=\"test.jpg\" class=\"w3-circle w3-bar-item  w3-margin contactImage\" alt=\"\"><br>\n" +
        "\n" +
        "<div class=\" w3-margin w3-bar\">\n" +
        "\n" +
        "<div class=\"w3-xlarge w3-bar-item\">\n" +
        "<h2 class=\"w3-left\">"+firstName+" "+lastName+"</h2> <br>\n" +
        "\n" +
        "<span class=\"w3-small w3-left\">phone: "+phoneNumber+"</span><br>\n" +
        "<span class=\"w3-small w3-left\">email: <a href=\"mailto:"+email+"\">"+email+"</span>\n" +
        "</div>\n" +
        "\n" +
        "\n" +
        "</div>\n" +
        "</div>";




 }





    return HTMLCode;
}




























































}
