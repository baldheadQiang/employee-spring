package cn.glutnn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.glutnn.entity.Employee;

import java.util.List;

public interface EmployeeService extends IService<Employee> {
    List<Employee> getEmpList();
    Integer deleteByUsername(String eUsername);
}
