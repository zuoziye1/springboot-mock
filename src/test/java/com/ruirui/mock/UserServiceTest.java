package com.ruirui.mock;

import com.ruirui.mock.entity.User;
import com.ruirui.mock.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * 参考：https://www.baeldung.com/mockito-series
 *
 * @Author: 姚飞虎
 * @Date: 2021/12/20 6:50 下午
 * @Description:
 */
@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserService userService ;


    /**
     * 调用某个方法时，就返回具体的某个值
     */
    @Test
    public void testMockNoArg(){
        Mockito.when(userService.checkExistIdEqualsOne()).thenReturn(false);

        System.out.println(userService.checkExistIdEqualsOne());
    }

    /**
     * 测试某个任何参数都返回具体的某个值
     */
    @Test
    public void testAnyArg(){
        Mockito.when(userService.getUserById(Mockito.anyInt())).thenReturn(new User(99999,"any"));

        System.out.println(userService.getUserById(4563));
    }
}
