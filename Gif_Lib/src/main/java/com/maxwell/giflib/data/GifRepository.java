package com.maxwell.giflib.data;

import com.maxwell.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by greermp on 6/20/2017.
 */
@Component  //This means it is injectable
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", LocalDate.of(2015,2,13), "Chris Ramacciotti", false, 2),
            new Gif("ben-and-mike", LocalDate.of(2015,10,30), "Ben Jakuben", true, 1),
            new Gif("book-dominos", LocalDate.of(2015,9,15), "Craig Dennis", false, 3),
            new Gif("compiler-bot", LocalDate.of(2015,2,13), "Ada Lovelace", true,1),
            new Gif("cowboy-coder", LocalDate.of(2015,2,13), "Grace Hopper", false,3),
            new Gif("infinite-andrew", LocalDate.of(2015,8,23), "Marissa Mayer", true,2)
    );

    public List<Gif> searchGifs(String query) {
        List<Gif> results = new ArrayList<>();
        query = query.toLowerCase();
        for (Gif gif : ALL_GIFS) {
            System.out.println(gif.getName().toLowerCase() + " " + query + " " + (gif.getName().toLowerCase().contains(query)));
            if (gif.getName().toLowerCase().contains(query) || gif.getUsername().toLowerCase().contains(query))
                results.add(gif);
        }
        return results;
    }

    public Gif getGifByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name))
                return gif;
        }
        return null;
    }

    public List<Gif> findById(int id) {
        List<Gif> gifListById = new ArrayList<>();
        for (Gif gif : ALL_GIFS)
            if (gif.getCategoryId() == id)
                gifListById.add(gif);

        return gifListById;
    }

    public List<Gif> getFavorites() {
        List<Gif> favoriteGifs = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.isFavorite())
                favoriteGifs.add(gif);
        }
        return favoriteGifs;
    }

    public  List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

}
