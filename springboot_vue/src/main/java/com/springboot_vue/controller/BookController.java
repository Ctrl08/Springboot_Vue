package com.springboot_vue.controller;

import com.springboot_vue.entity.Book;
import com.springboot_vue.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll")
    public List<Book>  findAll(){
        return bookRepository.findAll();
    }

    //分页
    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAllByPage(@PathVariable("page")Integer page, @PathVariable("size") Integer size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return bookRepository.findAll(pageRequest);
    }

    //添加数据
    @PostMapping("/save")
    public String save(@RequestBody Book book){
        System.out.println("前端传来的book-------"+book);
        Book saveBook = bookRepository.save(book);
        if (saveBook!=null){
            return "success";
        }else {
            return "error";
        }
    }

    //根据id查信息
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    //更新信息
    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        System.out.println("前端传来的book-------" + book);
        Book saveBook = bookRepository.save(book);
        if (saveBook != null) {
            return "success";
        } else {
            return "error";
        }
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
