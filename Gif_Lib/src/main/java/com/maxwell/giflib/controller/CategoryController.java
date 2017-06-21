package com.maxwell.giflib.controller;

import com.maxwell.giflib.data.CategoryRepository;
import com.maxwell.giflib.data.GifRepository;
import com.maxwell.giflib.model.Category;
import com.maxwell.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by greermp on 6/20/2017.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategorys(ModelMap modelMap) {
        List<Category> categories = categoryRepository.getCategories();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{categoryId}")
    public String getCategory(@PathVariable int categoryId, ModelMap modelMap) {
        Category category = categoryRepository.findById(categoryId);
        List<Category> categories = categoryRepository.getCategories();

       List <Gif> gifs = gifRepository.findById(categoryId);

        modelMap.put("category", category);
        modelMap.put("gifs", gifs);
        return "category";
    }
}
