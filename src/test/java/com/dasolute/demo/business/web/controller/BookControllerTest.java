package com.dasolute.demo.business.web.controller;

import com.dasolute.demo.business.web.entity.Book;
import com.dasolute.demo.business.web.service.BookService;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.time.LocalDateTime;
import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void Book_MVC_테스트() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());

        given(bookService.getBookList()).willReturn(Collections.singletonList(book));

        mvc.perform(get("/books"))
                .andExpect(status().isOk()) // HTTP 상태값이 200 OK 인지
                .andExpect(view().name("book")) // 반환되는 View 의 이름이 "book" 인지
                .andExpect(model().attributeExists("bookList")) // 모델 프로퍼티 중에 "bookList" 가 있는지
                .andExpect(model().attribute("bookList", contains(book))); // 그 bookList 중에 book 객체가 있는지
    }

}