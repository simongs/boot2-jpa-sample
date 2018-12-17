package com.dasolute.demo.business.web.repository;

import com.dasolute.demo.business.web.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
