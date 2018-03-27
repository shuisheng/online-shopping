package org.ssliao.shoppingbackend.dao;

import org.ssliao.shoppingbackend.dto.Category;

import java.util.List;

public interface CategoryDAO {

    List<Category> list();

    Category get(int id);

}
