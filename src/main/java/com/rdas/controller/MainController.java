package com.rdas.controller;

import com.rdas.exception.CustomGenericException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MainController {

    @RequestMapping(value = {"/hello", "/"}, method = RequestMethod.GET)
    public String hello(@RequestParam(value="name", defaultValue = "called withot empty name param") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

//    @ResponseBody
//    @RequestMapping(method = RequestMethod.POST, path = "angpost")
//    public ResponseEntity savePage(@RequestBody String formData) throws Exception {
//        System.out.println("-->> formData " + formData);
//        return new ResponseEntity("success", HttpStatus.OK);
//    }
//
    // The following request mapping is to demonstrate error handling using controller advice
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
    public ModelAndView getPages(@PathVariable("type") String type) throws Exception {
        if ("error".equals(type)) {
            // go handleCustomException
            throw new CustomGenericException("E888", "This is custom message");
        } else if ("io-error".equals(type)) {
            // go handleAllException
            throw new IOException();
        } else {
            return new ModelAndView("hello").addObject("name", type);
        }

    }
}