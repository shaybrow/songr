package com.shaybrow.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    AlbumRepo albumRepo;
    @Autowired
    SongRepo songRepo;

    @GetMapping("/song")
    public String songRender( Model m){
        List<Song> songs = songRepo.findAll();
        songs.add(new Song("Cash Machine", 230, 2));
        m.addAttribute("songs", songs);

        return "songs.html";
    }

    @PostMapping("/song")
    public RedirectView addSong(String title, int length, int trackNumber, long id){
        Album album = albumRepo.getOne(id);
        Song song = new Song (title, length, trackNumber);
        song.partOf = album;
         songRepo.save(song);
         return new RedirectView("/song");
    }
}
