package com.ruirui.mock;

import com.ruirui.mock.entity.Book;
import com.ruirui.mock.service.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @Author: 姚飞虎
 * @Date: 2021/9/22 10:48 上午
 * @Description:
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MockTest {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void bookApiTest() throws Exception {
        String title = "java learning";
        // mockbean 开始模拟
        bookServiceMockBean(title);
        // mockbean 模拟完成
        String expect = "{\"title\":\"java learning\",\"author\":\"dax\",\"price\":78.56,\"releaseTime\":\"2018-03-22\"}";
        mockMvc.perform(MockMvcRequestBuilders.get("/book/get")
                .param("title", title))
                .andExpect(MockMvcResultMatchers.content()
                        .json(expect))
                .andDo(MockMvcResultHandlers.print());
        // mockbean 重置
    }

    @Test
    public void bookServiceTest() {

        String title = "java learning";
        bookServiceMockBean(title);


        Assertions.assertThat(bookService.queryByTitle("ss").getTitle()).isEqualTo(title);

    }

    private void bookServiceMockBean(String title) {

        Book book = new Book();
        book.setAuthor("dax");
        book.setPrice(78.56);
        book.setReleaseTime(LocalDate.of(2018, 3, 22));
        book.setTitle(title);

        BDDMockito.given(bookService.queryByTitle(title)).willReturn(book);
    }
}
