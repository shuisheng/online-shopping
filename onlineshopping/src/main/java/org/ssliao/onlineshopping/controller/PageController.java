package org.ssliao.onlineshopping.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {
    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("page");
        //mv.addObject("greeting", "Welcome to Spring Web MVC");
        mv.addObject("title", "Home");
        mv.addObject("userClickHome", true);
        return mv;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About us");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact us");
        mv.addObject("userClickContact", true);
        return mv;
    }

    @RequestMapping(value="/test")
    public ModelAndView test(@RequestParam(value = "greeting", required = false)String greeting) {
        if (greeting == null) {
            greeting = "this is test";
        }
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", greeting);
        return mv;
    }

    @RequestMapping(value="/hello/{greeting}")
    public ModelAndView hello(@PathVariable("greeting")String greeting) {
        if (greeting == null) {
            greeting = "this is test";
        }
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("greeting", greeting);
        return mv;
    }
}
