package cn.glutnn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.glutnn.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
