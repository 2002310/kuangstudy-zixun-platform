package com.pug.zixun.controller;

import com.pug.zixun.config.AlipayProperties;
//import com.xing.config.AlipayService;
import com.pug.zixun.vo.UserVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "测试用例")
public class TestController {
    @GetMapping("/login")
    public String login(UserVO uservo, HttpSession session){
        session.setAttribute("userInfo",uservo);
        return "登陆成功";
    }

    @GetMapping("/userInfo")
    public UserVO userInfo(HttpSession session){
        return (UserVO) session.getAttribute("userInfo");
    }
















//    @Autowired
//    Environment environment;
//    @GetMapping("/getYml1")
//    public Map getYml(){
//        String key = environment.getProperty("alipay.key");
//        String openkey = environment.getProperty("alipay.openkey");
//        String javahome = environment.getProperty("JAVA_HOME");
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("key",key);
//        stringStringHashMap.put("openkey",openkey);
//        stringStringHashMap.put("javahome",javahome);
//        return stringStringHashMap;
//    }
//    @Value("${alipay.key}")
//    String key;
//    @Value("${alipay.openkey}")
//    String openkey;
//    @GetMapping("/getYml2")
//    public Map getYml2(){
//
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("key",key+"2");
//        stringStringHashMap.put("openkey",openkey+"2");
//        return stringStringHashMap;
//    }
//    @Autowired
//    AlipayProperties alipayProperties;
//    @GetMapping("/getYml3")
//    public Map getYml3(){
//
//        HashMap<String, Object> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("key",alipayProperties.getKey()+"3");
//        stringStringHashMap.put("map",alipayProperties.getMap());
//        stringStringHashMap.put("list",alipayProperties.getList());
//        stringStringHashMap.put("user",alipayProperties.getUser());
//        stringStringHashMap.put("openkey",alipayProperties.getOpenkey()+"3");
//        return stringStringHashMap;
    }
//    @Autowired
//    private AlipayService alipayService;
//    @GetMapping("/getYml4")
//    public String getYml4(){
//
//        return alipayService.pay();
//
//    }

//}
