package com.shaybrow.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {




    @GetMapping("/")
    public String home(){
        return "home.html";
    }
    @GetMapping("/hello")
    public String sayHello(){
        return "hello.html";
    }
    @GetMapping("/capitalize/{input}")
    public String toUpperCase(
            Model m,
        @PathVariable String input
    ){
        System.out.println("input = " + input);
        input = input.toUpperCase();
        m.addAttribute("input", input);
        return "capitalize.html";
    }


}
// http://localhost:8080/assets/c-d-x-PDX_a_82obo-unsplash.jpg