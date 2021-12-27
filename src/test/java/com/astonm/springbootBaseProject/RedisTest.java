package com.astonm.springbootBaseProject;

import com.astonm.springbootBaseProject.common.redis.IRedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
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

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void testRedisSet() {
        iRedisClient.set("test", "test");
        System.out.println(iRedisClient.get("test"));
    }

    @Test
    public void testRedisson() {
        RLock lock = redissonClient.getLock("lock");
        System.out.println("等待获取锁");
        lock.lock();
        try {
            System.out.println("加锁成功，执行业务");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("已释放锁");
        }
    }

    @Test
    public void testRedisson1() {
        RLock lock = redissonClient.getLock("lock");
        System.out.println("等待获取锁");
        lock.lock();
        try {
            System.out.println("加锁成功，执行业务");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("已释放锁");
        }
    }
}
