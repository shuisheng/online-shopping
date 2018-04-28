package org.ssliao.shoppingbackend.daoimpl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ssliao.shoppingbackend.dao.UserDAO;
import org.ssliao.shoppingbackend.dto.Address;
import org.ssliao.shoppingbackend.dto.Cart;
import org.ssliao.shoppingbackend.dto.User;

import java.beans.Transient;
import java.util.List;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean add(User user) {
        try {
            sessionFactory.getCurrentSession().persist(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Address getBillingAddress(User user) {
        String selectQuery = "FROM Address WHERE user= :user AND billing = :billing";
        try {
            return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
                    .setParameter("user", user)
                    .setParameter("billing", true)
                    .getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Address> listShippingAddress(User user) {
        String selectQuery = "FROM Address WHERE user= :user AND shipping = :shipping";
        try {
            return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class)
                    .setParameter("user", user)
                    .setParameter("shipping", true)
                    .getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }    }

    @Override
    public boolean addAddress(Address address) {
        try {
            sessionFactory.getCurrentSession().persist(address);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getByEmail(String email) {
        String selectQuery = "FROM User WHERE email = :email";

        try {
            return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class)
                    .setParameter("email", email).getSingleResult();
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateCart(Cart cart) {
        try {
            sessionFactory.getCurrentSession().update(cart);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
