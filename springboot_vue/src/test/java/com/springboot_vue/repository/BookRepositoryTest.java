package com.springboot_vue.repository;

import com.springboot_vue.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }

    @Test
    void save(){
        Book newBook = new Book();
        newBook.setName("springboot");
        newBook.setAuthor("lee");
        Book book = bookRepository.save(newBook);
        System.out.println(book);
    }
}