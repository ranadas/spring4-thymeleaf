package com.rdas.config;

import com.rdas.exception.CustomGenericException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rdas on 15/10/2016.
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(CustomGenericException ex) {
        ModelAndView model = new ModelAndView("error/generic_error");
        model.addObject("errCode", ex.getErrCode());
        model.addObject("errMsg", ex.getErrMsg());
        return model;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("error/generic_error");
        model.addObject("errMsg", "this is Exception.class");
        return model;
    }
//    /*
//    have a global init binder
//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder) {
//        webDataBinder.setBindEmptyMultipartFiles(false);
//    }
//     */
}
