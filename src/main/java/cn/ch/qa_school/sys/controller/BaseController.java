package cn.ch.qa_school.sys.controller;

import cn.hutool.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class BaseController {
    @Autowired
    public HttpServletRequest request;

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    public Result success() {
        return success("success");
    }

    public Result success(String message) {
        return success(HttpStatus.HTTP_OK, message, null);
    }

    public Result success(Object data) {
        return success(HttpStatus.HTTP_OK, "success", data);
    }

    public Result success(int code, String message, Object data) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public Result failure() {
        return failure(HttpStatus.HTTP_INTERNAL_ERROR, "error");
    }

    public Result failure(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static class Result implements Serializable {
        private Integer code;
        private String message;
        private Object data;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Result() {
        }

        public Result(Integer code, String message, Object data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }
    }
}
