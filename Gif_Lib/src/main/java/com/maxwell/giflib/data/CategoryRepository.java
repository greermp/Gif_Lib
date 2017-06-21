package com.maxwell.giflib.data;

import com.maxwell.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by greermp on 6/20/2017.
 */
@Component
public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
    new Category(1, "Funny"),
    new Category(2, "Scary"),
    new Category(3, "Sad")
    );

    /*
    public CategoryRepository() {
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Funny"));
        categoryList.add(new Category(2, "Scary"));
        categoryList.add(new Category(3, "Sad"));
    }
    */
    public List<Category> getCategories() {
        return new ArrayList<>(ALL_CATEGORIES);
    }

    public Category findById(int id) {
        for (Category cat : ALL_CATEGORIES) {
            if (cat.getId() == id)
                return cat;
        }
        return null;
    }

    public Category getCategoryByName(String name) {
        for (Category cat : ALL_CATEGORIES) {
            if (cat.getName().equals(name))
                return cat;
        }
        return null;
    }
}
