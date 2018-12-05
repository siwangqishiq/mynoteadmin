package com.mynote.admin.interceptor;

import com.mynote.admin.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一全局异常处理
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> apiErrorHandler(HttpServletRequest req, Exception e) {
        Result<String> r = new Result<>();
        r.setCode(Result.EEROR_CODE);
        r.setError(e.getMessage());
        r.setData(null);
        return r;
    }
}//end class
