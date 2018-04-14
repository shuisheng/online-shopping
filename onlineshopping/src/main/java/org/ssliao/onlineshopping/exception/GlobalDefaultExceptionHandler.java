package org.ssliao.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFoundException() {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("errorTitle", "The page is not constructed!");
        mv.addObject("errorDescription", "The page you are looking for is not available now!");
        mv.addObject("title", "404 Error Page");

        return mv;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleProductNoHandlerFoundException() {
        ModelAndView mv = new ModelAndView("error");

        mv.addObject("errorTitle", "Product not constructed!");
        mv.addObject("errorDescription", "The product you are looking for is not available now!");
        mv.addObject("title", "Product unavailable");

        return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView mv = new ModelAndView("error");

        // only for debugging your application
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);

        mv.addObject("errorTitle", "Contact your administrator!");
        mv.addObject("errorDescription", sw.toString());
        mv.addObject("title", "Error!");

        return mv;
    }
}

