package com.astonm.springbootBaseProject;

import com.astonm.springbootBaseProject.common.redis.IRedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * describe function here
 *
 * @author astonm
 * @date 2021/12/26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class RedisTest {

    @Autowired
    private IRedisClient iRedisClient;

    @Test
    public void testRedisSet() {
        iRedisClient.set("test", "test");
        System.out.println(iRedisClient.get("test"));
    }
}
