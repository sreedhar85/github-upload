package com.fis.casestudy.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fis.casestudy.library.model.Book;
import com.fis.casestudy.library.model.Subscriber;
import com.fis.casestudy.library.repository.BookRepository;
import com.fis.casestudy.library.repository.SubscriptionRepository;
import com.fis.casestudy.library.service.LibraryService;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest
{
    @Mock
    BookRepository         bookRepo;

    @Mock
    SubscriptionRepository subRepo;

    @InjectMocks
    LibraryService         libService;

    private Book           book1, book2;

    private Subscriber     sub1, sub2;

    List<Book>             books;

    List<Subscriber>       subList;

    @BeforeEach
    public void setup()
    {

        book1 = new Book();
        book1.setAuthor("James Gosling");
        book1.setAvailableCopies(2);
        book1.setBookId(111);
        book1.setBookName("Fundamentals of Java");
        book1.setTotalCopies(2);

        book2 = new Book();
        book2.setAuthor("Ross Sqarez");
        book2.setAvailableCopies(0);
        book2.setBookId(2222);
        book2.setBookName("History of Amazon Valley");
        book2.setTotalCopies(5);

        sub1 = new Subscriber();
        sub1.setBookId(111);
        sub1.setDateReturned("18-dec-2019");
        sub1.setDateSubscribed("12-dec-2019");
        sub1.setSubscriberName("naveen");

        sub2 = new Subscriber();
        sub2.setBookId(4232);
        sub2.setDateReturned("20-dec-2019");
        sub2.setDateSubscribed("11-dec-2019");
        sub2.setSubscriberName("Arjun");

        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        subList = new ArrayList<>();
        subList.add(sub1);
        subList.add(sub2);

    }

    @Test
    public void getAllSubscriptionsShouldReturnAllListOfSubscribers()
    {

        Mockito.when(subRepo.findAll()).thenReturn(subList);
        Optional<Subscriber> returnedSub = libService.getAllSubscriptions("naveen");
        assertEquals(sub1.getSubscriberName(), returnedSub.get().getSubscriberName());

        Mockito.verify(subRepo, Mockito.times(1)).findById(Mockito.eq("naveen"));
    }

}
