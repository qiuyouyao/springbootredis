package com.tutu;

import com.tutu.bean.User;
import com.tutu.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
    RedisTemplate<String, String> stringRedisTemplate;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedisUtil redisUtil;

    @Test
    void testRedisUtil(){
        String key = "tutu";
        System.out.println(redisUtil.get(key));
    }

    @Test
    void contextLoads() {
        String key = "location";
        String value = "China";
        stringRedisTemplate.opsForValue().set(key,value);
        System.out.println(stringRedisTemplate.opsForValue().get(key));
    }

    @Test
    void testRedisTemplate() {
        User user = new User();
        user.setId(1L);
        user.setUsername("tutu");
        user.setGender("男");
        user.setAge(18);
        String key = "tutu";
        redisTemplate.opsForValue().set(key, user);
        User result = (User) redisTemplate.opsForValue().get(key);
        System.out.println(result);
    }
}
