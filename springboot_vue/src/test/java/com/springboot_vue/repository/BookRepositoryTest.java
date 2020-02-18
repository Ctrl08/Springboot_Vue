package com.springboot_vue.repository;

import com.springboot_vue.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


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

    @Test
    void findById(){
        Book book = bookRepository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(6);
        book.setName("Java抓娃");
        book.setAuthor("维系布鲁克");
        bookRepository.save(book);
    }

    @Test
    void deleteById(){
        bookRepository.deleteById(10);
    }
}