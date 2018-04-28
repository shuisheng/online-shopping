package org.ssliao.shoppingbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.ssliao.shoppingbackend.dao.UserDAO;
import org.ssliao.shoppingbackend.dto.Address;
import org.ssliao.shoppingbackend.dto.Cart;
import org.ssliao.shoppingbackend.dto.User;

import static org.junit.Assert.assertEquals;

public class UserTestCase {
    private static AnnotationConfigApplicationContext context;
    private static UserDAO userDAO;
    private User user = null;
    private Cart cart = null;
    private Address address = null;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("org.ssliao.shoppingbackend");
        context.refresh();

        userDAO = (UserDAO) context.getBean("userDAO");
    }

//    @Test
//    public void testAdd() {
//
//        user = new User();
//        user.setFirstName("Hrithik");
//        user.setLastName("Roshan");
//        user.setEmail("hr@gmail.com");
//        user.setContactNumber("1234512345");
//        user.setRole("USER");
//        //user.setEnabled(true);
//        user.setPassword("12345");
//        assertEquals("Failed to add user!", true, userDAO.add(user));
//
//
//        address = new Address();
//        address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
//        address.setAddressLineTwo("Near Kaabil Store");
//        address.setCity("Mumbai");
//        address.setState("Maharashtra");
//        address.setCountry("India");
//        address.setPostalCode("400001");
//        address.setBilling(true);
//        // linked the address with the user
//        address.setUserId(user.getId());
//        assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
//
//        if (user.getRole().equals("USER")) {
//            cart = new Cart();
//            cart.setUser(user);
//            assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
//
//            // add the shipping address
//            address = new Address();
//            address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
//            address.setAddressLineTwo("Near Kudrat Store");
//            address.setCity("Mumbai");
//            address.setState("Maharashtra");
//            address.setCountry("India");
//            address.setPostalCode("400001");
//            //address.setUser(user);
//            address.setShipping(true);
//
//            address.setUserId(user.getId());
//            assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
//        }
//
//    }


//    @Test
//    public void testAdd() {
//        user = new User();
//        user.setFirstName("Hrithik");
//        user.setLastName("Roshan");
//        user.setEmail("hr@gmail.com");
//        user.setContactNumber("1234512345");
//        user.setRole("USER");
//        //user.setEnabled(true);
//        user.setPassword("12345");
//
//        if (user.getRole() == "USER") {
//            cart = new Cart();
//            cart.setUser(user);
//            user.setCart(cart);
//        }
//
//        assertEquals("Failed to add user!", true, userDAO.add(user));
//    }

//    @Test
//    public void testUpdateCart() {
//        user = userDAO.getByEmail("hr@gmail.com");
//
//        cart = user.getCart();
//
//        cart.setGrandTotal(5555);
//        cart.setCartLines(2);
//
//        assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
//    }

    /*
    @Test
    public void testAddAddress() {
        user = new User();
        user.setFirstName("Hrithik");
        user.setLastName("Roshan");
        user.setEmail("hr@gmail.com");
        user.setContactNumber("1234512345");
        user.setRole("USER");
        //user.setEnabled(true);
        user.setPassword("12345");
        assertEquals("Failed to add user!", true, userDAO.add(user));

        address = new Address();
        address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
        address.setAddressLineTwo("Near Kaabil Store");
        address.setCity("Mumbai");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setPostalCode("400001");
        address.setBilling(true);

        address.setUser(user);

        assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));

        address = new Address();
        address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
        address.setAddressLineTwo("Near Kudrat Store");
        address.setCity("Mumbai");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setPostalCode("400001");
        //address.setUser(user);
        address.setShipping(true);

        address.setUser(user);
        assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
    }
    */

    /*
    @Test
    public void testAddAddress() {
        user = userDAO.getByEmail("hr@gmail.com");

        address = new Address();
        address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
        address.setAddressLineTwo("Near Kaabil Store");
        address.setCity("Mumbai");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setPostalCode("400001");
        address.setBilling(true);

        address.setUser(user);

        assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
    }
    */

    @Test
    public void testGetAddress() {
        user = userDAO.getByEmail("hr@gmail.com");

        assertEquals("Failed to fetch the list of address and size does not match!", 1, userDAO.listShippingAddress(user).size());
    }
}
