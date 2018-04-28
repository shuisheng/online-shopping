package org.ssliao.shoppingbackend.dao;

import org.ssliao.shoppingbackend.dto.Address;
import org.ssliao.shoppingbackend.dto.Cart;
import org.ssliao.shoppingbackend.dto.User;

import java.util.List;

public interface UserDAO {
    boolean add(User user);
    User getByEmail(String email);
    boolean addAddress(Address address);
    Address getBillingAddress(User user);
    List<Address> listShippingAddress(User user);
    boolean updateCart(Cart cart);
}

