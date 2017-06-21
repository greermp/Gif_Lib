package com.maxwell.giflib.controller;

import com.maxwell.giflib.data.CategoryRepository;
import com.maxwell.giflib.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by greermp on 6/20/2017.
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/categories")
    public String getCategorys(ModelMap modelMap) {
        List<Category> catList = categoryRepository.getCategories();
        modelMap.put("catList", catList);
        return "categories";
    }
}
