package cn.glutnn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.glutnn.entity.Employee;
import cn.glutnn.mapper.EmployeeMapper;
import cn.glutnn.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getEmpList() {
        return employeeMapper.selectList(null);
    }

    @Override
    public Integer deleteByUsername(String eUsername) {
        LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        employeeLambdaQueryWrapper.eq(Employee::getUsername,eUsername);
        return employeeMapper.delete(employeeLambdaQueryWrapper);
    }
}
