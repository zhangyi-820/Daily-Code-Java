package com.example.easypoidemo.controller.dto;

import lombok.Data;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/10/28 10:24
 * @description：返回体
 * @modified By：
 * @version:
 */
@Data
public class ResponseBody {
    private Integer code;
    private Object data;

    public ResponseBody(Integer code,Object data){
        this.code=code;
        this.data=data;
    }

    public static ResponseBody buildSuccess(){
        return new ResponseBody(200,null);
    }

    public static ResponseBody buildSuccessWithData(Object data){
        return new ResponseBody(200,data);
    }

    public static ResponseBody build(Integer code,Object data){
        return new ResponseBody(code,data);
    }
}
