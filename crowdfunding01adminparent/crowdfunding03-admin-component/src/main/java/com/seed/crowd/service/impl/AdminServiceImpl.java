package com.seed.crowd.service.impl;

import com.seed.crowd.entity.Admin;
import com.seed.crowd.entity.AdminExample;
import com.seed.crowd.mapper.AdminMapper;
import com.seed.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public void saveAdmin(Admin admin) throws Exception {
        adminMapper.insert(admin);
    }

    public List<Admin> findAll() throws Exception {
        return adminMapper.selectByExample(new AdminExample());
    }
}
