package com.pug.zixun.controller.user;

import com.pug.zixun.controller.base.BaseController;
import org.springframework.web.bind.annotation.*;

@RestController
//@Slf4j
public class UserController extends BaseController {

    //    @Autowired
//    private UserService service;
//
//    @GetMapping("/user/{id}")
//    public R getUser(@PathVariable("id") Integer id){
//        User byId = service.getById(id);
//        if (byId==null){
//            throw new RuntimeException("用户找不到");
//        }
//        return R.success(AdminSuccessResultEnum.ADMIN_SUCCESS,byId);
//    }
//    @PostMapping("/user/save")
//
//    public User saveUser(@RequestBody UserVO userVO){
//        if (userVO.getUserName()==null) {
//            throw new RuntimeException("用户名为空");
//        }
//        User user = new User();
//        return user;
//    }

    @PostMapping("/user/save")
    public String saveUser() {
        return "成功";
    }


}
