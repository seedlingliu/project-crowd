package com.seed.crowd;

import com.seed.crowd.entity.Admin;
import com.seed.crowd.mapper.AdminMapper;
import com.seed.crowd.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

// 在类上标记必要的注解，spring整合junit

/**
 * @RunWith 不加该注解，dataSource.getConnection()会触发空指针异常
 * @ContextConfiguration 作用加载配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void textTx() throws Exception {
        Admin admin = new Admin(null, "lucy", "lucy", "露西", "luxi@qq.com", null);
        adminService.saveAdmin(admin);
    }

    @Test
    public void testLogger(){
//        LoggerFactory
    }

    @Test
    public void testInsertAdmin(){
        Admin admin = new Admin(null, "seed", "seed", "seedling", "11@qq.com", null);
        int count = adminMapper.insert(admin);
        System.out.println(count);
    }

    @Test
    public void testConnection() throws Exception{
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
