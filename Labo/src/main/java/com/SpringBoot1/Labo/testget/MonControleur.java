package com.SpringBoot1.Labo.testget;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MonControleur {

    @GetMapping(value = "/test/{coucou}}/test")
    public @ResponseBody String test(@PathVariable Long coucou, @RequestParam(required = false,name = "id") String monSuperID){
        System.out.println("Requête reçue : " + coucou + " " + monSuperID);
        return (coucou / 2) + "";
    }

    @GetMapping(value = "/bonjour")
    public @ResponseBody String bonjour() {
        System.out.println("Requête reçu sur bonjour ");
        return "bonjour tout le monde";
    }

}
