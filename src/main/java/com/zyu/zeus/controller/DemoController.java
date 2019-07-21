package com.zyu.zeus.controller;

import com.zyu.zeus.define.SecurityParameter;
import com.zyu.zeus.pojo.Persion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/5/25 11:11
 */
@Controller
public class DemoController {

    private static final Logger logger= LoggerFactory.getLogger(DemoController.class);

//    @ApiOperation(value = "根据id查询学生信息", notes = "查询数据库中某个的学生信息")
//    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
//    @GetMapping("/test")
//    public String test() {
//        return "测试1234";
//    }


    @RequestMapping("/test")
    public String goTest() {
        return "test";
    }

    /**
     * RSA+AES双重加密测试
     *
     * @return object
     */
    @RequestMapping("/testEncrypt")
    @ResponseBody
    @SecurityParameter
    public Persion testEncrypt(@RequestBody Persion info) {
        System.out.println(info.getName());
        String content = "内容";
        info.setName(content);
        return  info;
    }

}