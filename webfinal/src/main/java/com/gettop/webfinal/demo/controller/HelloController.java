package com.gettop.webfinal.demo.controller;

import com.gettop.webfinal.common.log.LogUtils;
import com.gettop.webfinal.common.output.ResponseDTO;
import com.gettop.webfinal.demo.modal.Test;
import com.gettop.webfinal.demo.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/*Controller层只做2件事：1获取并校验入参，2由Service层获取处理结果并返回*/
@Controller
@RequestMapping(value = "/hello")
public class HelloController {


    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private TestService testService;

    //@ResponseBody
    @RequestMapping(value = "/world")
    public String addMessage() {
        Test test = testService.getById(1);
        System.out.println(test);
        logger.error("error test");
        return "index";
    }

    @ResponseBody
    @RequestMapping("outputTest")
    public ResponseDTO<Test> common(HttpServletRequest request, String msg) {
        Test test = new Test();
        TestService testService = new TestService();

        return ResponseDTO.success(test);
        //return ResponseDTO.success(testService); //编译错误
        //return ResponseDTO.fail("错误信息");
        //return ResponseDTO.success();
    }

    @ResponseBody
    @RequestMapping("logTest")
    public ResponseDTO<Test> common(HttpServletRequest request) {
        Logger log_platform = LogUtils.getPlatformLogger();
        Logger log_exception = LogUtils.getExceptionLogger();
        Logger log_business = LogUtils.getBusinessLogger();
        Logger log_db = LogUtils.getDBLogger();
        log_platform.error("日志测试:platform");
        log_exception.error("日志测试:exception");
        log_business.error("日志测试:business");
        log_db.error("日志测试:DB");

        return ResponseDTO.success(null);
    }


}
