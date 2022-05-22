package cn.ch.qa_school.sys.exeception;

import cn.ch.qa_school.sys.controller.BaseController;
import cn.hutool.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger LOG = LoggerFactory.getLogger(getClass());


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    BaseController.Result handleException(Exception e, HttpServletRequest request) {
        LOG.error("GlobalExceptionHandler-> url:{} msg:{}", request.getRequestURI(), e.getMessage());
        return new BaseController.Result(HttpStatus.HTTP_BAD_REQUEST, e.getMessage(), null);
    }
}
