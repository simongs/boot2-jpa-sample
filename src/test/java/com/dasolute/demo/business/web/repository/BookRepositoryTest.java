package com.dasolute.demo.business.web.repository;

import com.dasolute.demo.business.web.entity.Book;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void Book_저장하기_테스트() {
        Book book = Book.builder().title("타이틀").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book);

        assertThat(bookRepository.getOne(book.getIdx()), is(book));

    }
}