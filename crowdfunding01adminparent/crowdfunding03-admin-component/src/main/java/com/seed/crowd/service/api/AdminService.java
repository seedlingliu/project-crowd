package com.seed.crowd.service.api;

import com.seed.crowd.entity.Admin;

import java.util.List;

public interface AdminService {
    void saveAdmin(Admin admin) throws Exception;

    List<Admin> findAll() throws Exception;
}
