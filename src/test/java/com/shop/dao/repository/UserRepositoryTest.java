package com.shop.dao.repository;

import com.shop.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Krzysztof Januś on 2015-02-05.
 */
@Transactional
@Configuration("")
public class UserRepositoryTest {
    @Autowired
    @Qualifier("userRepository")
    private UserDao userRepository;

    @Test
    public void test() {
        System.out.println(userRepository);
    }
}
