package cn.glutnn.service.impl;

import cn.glutnn.entity.Admin;
import cn.glutnn.mapper.AdminMapper;
import cn.glutnn.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements AdminService{
}
