package cn.glutnn.controller;

import cn.glutnn.common.R;
import cn.glutnn.entity.Admin;
import cn.glutnn.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cn.glutnn.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;
    //新增员工
    @PostMapping("/add")
    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        log.info("新增员工，员工信息：{}",employee.toString());
        //设置初始密码为123456
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        employee.setCreateUser(admin.getId());
        employee.setUpdateUser(admin.getId());
        employeeService.save(employee);
        return R.success("员工新增成功");
    }
    //获取员工列表
    @GetMapping("/getEmployeeList")
    public R<List<Employee>> getEmployeeList(){
        return R.success(employeeService.getEmpList());
    }

    //修改员工信息
    @PostMapping("/updateEmployee")
    public R<Boolean> updateEmployee(@RequestBody Employee employee){
        LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        employeeLambdaQueryWrapper.eq(Employee::getUsername,employee.getUsername());
        boolean b = employeeService.update(employeeLambdaQueryWrapper);
        log.info("运行结果：{}",b);
        return R.success(b);
    }
    //删除员工
    @PostMapping("/deleteEmployee")
    public R<String> deleteEmployee(@RequestBody String eUsername){
        log.info("前端传过来的用户名"+eUsername);
        final Integer res = employeeService.deleteByUsername(eUsername);
        log.info(" {删除结果}",res);
        if(res == 1){
            return R.success("删除成功！");
        }
        return R.error("删除失败！");
    }

}
