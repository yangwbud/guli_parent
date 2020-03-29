package com.yang.servicebase.handler;


import com.yang.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error();
    }


    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("下啊，哪儿出错！");
    }


    @ExceptionHandler(YangException.class)
    @ResponseBody
    public R error(YangException e){
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }


}
