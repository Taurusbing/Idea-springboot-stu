package com.hpe.controller;
        import com.hpe.pojo.User;
        import com.hpe.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;
        import org.springframework.web.servlet.ModelAndView;

        import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {

    @Autowired
    private UserService userService;

    //@RequestMapping(value = "hello",method = RequestMethod.GET),  注意：spring4.3以后可以像下面写法
    @GetMapping("hello")
    @ResponseBody
    public User hello(){
        User user = this.userService.queryById(1);
        return user;
    }

    @GetMapping("all")
    public String all(Model model){
        //查询数据
        List<User> users = userService.selectAll();
        //放入模型
        model.addAttribute("users",users);
        //返回模板名称（就是classpath:/templates/目录下的user.html文件）
        return "user";
    }

}
