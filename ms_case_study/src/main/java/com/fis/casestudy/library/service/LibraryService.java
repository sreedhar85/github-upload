package com.fis.casestudy.library.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.fis.casestudy.library.model.Book;
import com.fis.casestudy.library.model.Subscriber;
import com.fis.casestudy.library.repository.BookRepository;
import com.fis.casestudy.library.repository.SubscriptionRepository;

@Service
public class LibraryService
{
    @Autowired
    BookRepository         bookRepository;

    @Autowired
    SubscriptionRepository subRepository;

    public List<Book> getAll()
    {
        return bookRepository.findAll();

    }

    public Optional<Subscriber> getAllSubscriptions(String subName)
    {
        return subRepository.findById(subName);

    }

    @Transactional(
            dontRollbackOn = ResourceNotFoundException.class)
    public Subscriber createSubscription(Subscriber subscriber)
    {

        Subscriber savedSubscriber = subRepository.saveAndFlush(subscriber);
        createBook(savedSubscriber.getBookId());

        return savedSubscriber;
    }

    private void createBook(Integer bookId)
    {
        Book savedBook = new Book();

        Optional<Book> books = bookRepository.findById(bookId);
        if (books.get().getAvailableCopies() > 0)
        {
            savedBook.setBookId(bookId);
            bookRepository.save(savedBook);
        }
        else
        {
            throw new ResourceNotFoundException("Book with ID " + bookId + " is not available to Issue");
        }

    }

}
