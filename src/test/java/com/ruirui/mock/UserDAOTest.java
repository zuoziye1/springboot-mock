package com.ruirui.mock;

import com.ruirui.mock.dao.UserDao;
import com.ruirui.mock.entity.User;
import com.ruirui.mock.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * https://kucw.github.io/blog/2020/2/spring-unit-test-mockito/
 * @Author: 姚飞虎
 * @Date: 2021/9/24 2:24 下午
 * @Description:
 */
@SpringBootTest
public class UserDAOTest {

    //先普通的注入一個userService bean
    @Autowired
    private UserService userService;

    /**
     * 但是如果 userDao 還沒寫好，又想先測 userService 的話，就需要使用 Mockito 去模擬一個假的 userDao 出來
     *
     * 使用方法是在 userDao 上加上一個 @MockBean 注解，當 userDao 被加上這個注解之後，表示 Mockito 會幫我們創建一個假的 mock 對象，替換掉 Spring 中已存在的那個真實的 userDao bean，也就是說，注入進 userService 的 userDao bean，已經被我們替換成假的 mock 對象了，所以當我們再次調用 userService 的方法時，會去調用的實際上是 mock userDao bean 的方法，而不是真實的 userDao bean
     *
     * 當我們創建了一個假的 userDao 後，我們需要為這個 mock userDao 自定義方法的返回值，這裡有一個公式用法，下面這段 code 的意思為，當調用了某個 mock 對象的方法時，就回傳我們想要的自定義結果
     */
    @MockBean
    private UserDao userDao ;

    @Test
    public void testGetUser(){
        // 定義當調用mock userDao的getUserById()方法，並且參數為3時，就返回id為200、name為I'm mock3的user對象
        Mockito.when(userDao.getUserById(3))
                .thenReturn(new User(200, "I'm mock 3"));

        User userById = userService.getUserById(3);
        System.out.println(userById);

        User uu = userService.getUserById(5);
        System.out.println(uu);
    }
}
