package org.ssliao.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.ssliao.shoppingbackend.dao.CategoryDAO;
import org.ssliao.shoppingbackend.dto.Category;

import static org.junit.Assert.assertEquals;


public class CategoryTestCase {
    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private Category category;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("org.ssliao.shoppingbackend");
        context.refresh();

        categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
    }

//    @Test
//    public void testAddCategory() {
//        Category category = new Category();
//
//        category.setName("Television");
//        category.setDescription("This is some description for television.");
//        category.setImageUrl("CAT_1.png");
//
//        assertEquals("Successfully add a category inside the table!", true, categoryDAO.add(category));
//    }

//    @Test
//    public void testGetCategory() {
//        category = categoryDAO.get(19);
//
//        assertEquals("Successfully get a category by id!", "Television", category.getName());
//
//    }

//    @Test
//    public void testUpdateCategory() {
//        category = categoryDAO.get(19);
//        category.setName("TV");
//
//        assertEquals("Successfully update a category inside the table!", true, categoryDAO.update(category));
//    }

//    @Test
//    public void testDeleteCategory() {
//        category = categoryDAO.get(19);
//        category.setName("TV");
//
//        assertEquals("Successfully delete a category inside the table!", true, categoryDAO.delete(category));
//    }

//    @Test
//    public void testListCategory() {
//        assertEquals("Successfully delete a category inside the table!", 1, categoryDAO.list().size());
//    }

    @Test
    public void testCRUDCategory() {

        // add operation
        category = new Category();

        category.setName("Laptop");
        category.setDescription("This is some description for laptop!");
        category.setImageUrl("CAT_1.png");

        assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));


        category = new Category();

        category.setName("Television");
        category.setDescription("This is some description for television!");
        category.setImageUrl("CAT_2.png");

        assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));


        // fetching and updating the category
        category = categoryDAO.get(2);

        category.setName("TV");

        assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));


        // delete the category
        assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));


        //fetching the list
        assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());


    }

}
