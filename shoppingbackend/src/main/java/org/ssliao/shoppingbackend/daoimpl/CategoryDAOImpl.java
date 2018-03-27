package org.ssliao.shoppingbackend.daoimpl;

import org.springframework.stereotype.Repository;
import org.ssliao.shoppingbackend.dao.CategoryDAO;
import org.ssliao.shoppingbackend.dto.Category;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

    private static List<Category> categories = new ArrayList<>();

    static {
        Category category = new Category();

        category.setId(1);
        category.setName("Television");
        category.setDescription("This is some description for television.");
        category.setImageUrl("CAT_1.png");

        categories.add(category);

        category = new Category();
        category.setId(2);
        category.setName("Mobile");
        category.setDescription("This is some description for mobile.");
        category.setImageUrl("CAT_2.png");

        categories.add(category);

        category = new Category();
        category.setId(3);
        category.setName("Laptop");
        category.setDescription("This is some description for Laptop.");
        category.setImageUrl("CAT_3.png");

        categories.add(category);
    }

    @Override
    public List<Category> list() {
        return categories;
    }

    @Override
    public Category get(int id) {
        for (Category category: categories) {
            if (category.getId() == id) {
                return category;
            }
        }

        return null;
    }
}
