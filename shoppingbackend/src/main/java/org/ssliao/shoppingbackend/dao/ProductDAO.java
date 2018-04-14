package org.ssliao.shoppingbackend.dao;

import org.ssliao.shoppingbackend.dto.Product;

import java.util.List;

public interface ProductDAO {
    Product get(int productId);
    List<Product> list();
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(Product product);

    // business methods
    List<Product> listActiveProducts();
    List<Product> listActiveProductByCategory(int categoryId);
    List<Product> getLatestActiveProduct(int count);
}
