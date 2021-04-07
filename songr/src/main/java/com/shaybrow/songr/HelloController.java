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
    @Autowired
    public AlbumRepo albumRepo;

    static ArrayList <Album> albums = new ArrayList<>();
    static {
        albums.add(new Album("Humanz", "Gorillaz", 25, 2000,
                "https://img.apmcdn.org/72919f8057242b2533c1038f95667f66f4601d69/uncropped/1cdefb-20170323-humanz-art.jpg" ));
        albums.add(new Album("The Moon & Antarctica", "Modest Mouse", 15, 1300,
                "https://images-na.ssl-images-amazon.com/images/I/61U1fpNPq2L._SX425_.jpg" ));
        albums.add(new Album("Ugly is Beautiful", "Oliver Tree", 14, 1400,
                "https://t2.genius.com/unsafe/300x0/https%3A%2F%2Fimages.genius.com%2Fd01ae63bd1f7c9410e36dfe463f21c87.1000x1000x1.png" ));
    }



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
    @GetMapping("/albums")
    public String albumsRender(
            Model m
    ){
         List<Album> albums = albumRepo.findAll();

        m.addAttribute("albums", albums);

        return "albums.html";
    }
    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imgUrl){
        Album input = new Album(title, artist, songCount, length, imgUrl);
        albums.add(input);
        albumRepo.save(input);
        return new RedirectView("/albums");

    }

}
// http://localhost:8080/assets/c-d-x-PDX_a_82obo-unsplash.jpg