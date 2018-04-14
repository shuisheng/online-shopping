package org.ssliao.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.ssliao.shoppingbackend.dao.ProductDAO;
import org.ssliao.shoppingbackend.dto.Product;

import static org.junit.Assert.assertEquals;

public class ProductTestCase {
    private static AnnotationConfigApplicationContext context;

    private static ProductDAO productDAO;

    private Product product;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("org.ssliao.shoppingbackend");
        context.refresh();
        productDAO = (ProductDAO)context.getBean("productDAO");
    }

    @Test
    public void testCRUDProduct() {
        // create one new product
        Product product = new Product();
        product.setName("Oppo Selfie S53");
        product.setBrand("Oppo");
        product.setDescription("This is some description for oppo mobile phones!");
        product.setUnitPrice(25000);
        product.setActive(true);
        product.setCategoryId(3);
        product.setSupplierId(3);

        assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

        // reading and updating the category
        product = productDAO.get(2);
        product.setName("Samsung Galaxy S7");
        assertEquals("Something went wrong while updating the existing product!", true, productDAO.update(product));

        assertEquals("Something went wrong while deleting the existing product!", true, productDAO.delete(product));

        assertEquals("Something went wrong while deleting the existing product!", 4, productDAO.list().size());

        //assertEquals("Something went wrong while fetching the list of products!", true, productDAO.delete(product));

    }
}
