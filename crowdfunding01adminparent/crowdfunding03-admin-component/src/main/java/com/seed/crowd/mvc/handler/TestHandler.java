package com.seed.crowd.mvc.handler;

import com.seed.crowd.entity.Admin;
import com.seed.crowd.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping("/testHandler")
public class TestHandler {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/ssm.html")
    public String testSSM(ModelMap modelMap) throws Exception {
        List<Admin> adminList = adminService.findAll();
        modelMap.addAttribute("adminList",adminList);
        return "target";
    }
}
