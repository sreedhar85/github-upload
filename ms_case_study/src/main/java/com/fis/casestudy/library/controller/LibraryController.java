package com.fis.casestudy.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.casestudy.library.model.Book;
import com.fis.casestudy.library.model.Subscriber;
import com.fis.casestudy.library.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController
{
    @Autowired
    LibraryService libraryService;

    @GetMapping("/books")
    public List<Book> getAllBooks()
    {
        return libraryService.getAll();
    }

    @GetMapping("/subscriptions/{subName}")
    public Optional<Subscriber> getAllSubscriptions(@PathVariable
    String subName)
    {
        return libraryService.getAllSubscriptions(subName);
    }

    @PostMapping
    public Subscriber createSubscriber(@RequestBody
    Subscriber subscriber) throws Exception
    {
        return libraryService.createSubscription(subscriber);
    }

}
