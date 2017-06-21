package com.maxwell.giflib.controller;

/**
 * Handles requests to any pages of app listing GIFs, or a single GIF
 * Created by greermp on 6/18/2017.
 */

import com.maxwell.giflib.data.GifRepository;
import com.maxwell.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepo;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepo.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    //Example of a path variable [ {name} ]
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepo.getGifByName(name);
                //new Gif("compiler-bot", LocalDate.of(2015,2,13), "Max Greer", true);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String listFavorites(ModelMap modelMap) {
        List<Gif> favoriteGifs = gifRepo.getFavorites();
        modelMap.put("favoriteGifs", favoriteGifs);
        return "favorites";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String q, ModelMap modelMap) {
        List<Gif> searchResults = gifRepo.searchGifs(q);
        //searchResults.forEach(gif -> System.out.println(gif.getName()));
        modelMap.put("searchResults", searchResults);
        return "search-results";
    }

}
