package org.ssliao.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.ssliao.onlineshopping.util.FileUploadUtility;
import org.ssliao.onlineshopping.validator.ProductValidator;
import org.ssliao.shoppingbackend.dao.CategoryDAO;
import org.ssliao.shoppingbackend.dao.ProductDAO;
import org.ssliao.shoppingbackend.dto.Category;
import org.ssliao.shoppingbackend.dto.Product;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/manage")
public class ManagementController {
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;

    private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView showManagerProducts(@RequestParam(name = "operation", required = false) String operation) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageProducts", true);
        mv.addObject("title", "Manage Products");

        Product nProduct = new Product();
        nProduct.setSupplierId(1);
        nProduct.setActive(true);
        nProduct.setName("test");
        nProduct.setBrand("abc");
        nProduct.setQuantity(100);
        mv.addObject("product", nProduct);

        if (operation != null) {
            if (operation.equals("product")) {
                mv.addObject("message", "Product Submitted Successfully!");
            } else if (operation.equals("category")) {
                mv.addObject("message", "Category Submitted Successfully!");
            }
        }

        return mv;
    }

    @RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
    public ModelAndView showEditProduct(@PathVariable int id) {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("userClickManageProducts", true);
        mv.addObject("title", "Manage Products");

        Product nProduct = productDAO.get(id);
        mv.addObject("product", nProduct);
        return mv;
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result,
                                          Model model, HttpServletRequest request) {
        if (mProduct.getId() == 0) {
            new ProductValidator().validate(mProduct, result);
        } else {
            if (!mProduct.getFile().getOriginalFilename().equals("")) {
                new ProductValidator().validate(mProduct, result);
            }
        }

        // check there are any errors
        if (result.hasErrors()) {
            model.addAttribute("userClickManageProducts", true);
            model.addAttribute("title", "Manage Products");
            model.addAttribute("message", "Validation failed for product Submission!");

            return "page";
        }


        logger.info("add test product: " + mProduct.toString());

        if (mProduct.getId() == 0) {
            // create a new product record
            productDAO.add(mProduct);
        } else {
            productDAO.update(mProduct);
        }


        if (!mProduct.getFile().getOriginalFilename().equals("")) {
            FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
        }

        return "redirect:/manage/product?operation=product";
    }

    @RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
    @ResponseBody
    public String handleProductActivation(@PathVariable int id) {
        Product product = productDAO.get(id);
        boolean isActive = product.isActive();
        product.setActive(!product.isActive());
        productDAO.update(product);

        return isActive ? "You have successfully deactivate the product with id " + product.getId() :
                "You have successfully activate the product with id " + product.getId();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public String handleCategorySubmission(@ModelAttribute Category category) {
        categoryDAO.add(category);

        return "redirect:/manage/product?operation=category";
    }

    // return categories for all request mapping
    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryDAO.list();
    }

    @ModelAttribute("category")
    public Category getCategory() {
        return new Category();
    }

}
