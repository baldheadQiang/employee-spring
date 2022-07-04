package cn.glutnn.controller;

import cn.glutnn.common.R;
import cn.glutnn.entity.Admin;
import cn.glutnn.entity.Employee;
import cn.glutnn.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public R<Admin> login(HttpServletRequest req, @RequestBody Admin admin){
        //1.将密码进行md5加密处理
        System.out.println("admin = " + admin);
        String pwd = admin.getPassword();
        pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());

        //2.根据用户名查数据库
        LambdaQueryWrapper<Admin> adminLambdaQueryWrapper = new LambdaQueryWrapper<>();
        adminLambdaQueryWrapper.eq(Admin::getUsername,admin.getUsername());
        final Admin adm = adminService.getOne(adminLambdaQueryWrapper);

        //3.判断
        if(adm == null){
            return R.error("用户不存在");
        }
        //4.密码比对
        if(!adm.getPassword().equals(pwd)){
            return R.error("密码错误");
        }
        //5.登录成功
        req.getSession().setAttribute("admin",adm);
        return R.success(adm);
    }
    @RequestMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return R.success("退出成功");
    }


}
