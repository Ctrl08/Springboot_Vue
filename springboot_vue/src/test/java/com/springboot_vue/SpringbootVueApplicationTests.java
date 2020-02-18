package com.springboot_vue;

import com.springboot_vue.entity.Book;
import com.springboot_vue.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class SpringbootVueApplicationTests {

    //测试分页

    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Book> page = bookRepository.findAll(pageRequest);
        int i = 1;
    }

}