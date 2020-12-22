package com.fis.casestudy.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscriber
{
    @Id
    String subscriberName;

    String dateSubscribed;

    String dateReturned;

    int    bookId;

    public String getSubscriberName()
    {

        return subscriberName;
    }

    public void setSubscriberName(String subscriberName)
    {

        this.subscriberName = subscriberName;
    }

    public String getDateSubscribed()
    {

        return dateSubscribed;
    }

    public void setDateSubscribed(String dateSubscribed)
    {

        this.dateSubscribed = dateSubscribed;
    }

    public String getDateReturned()
    {

        return dateReturned;
    }

    public void setDateReturned(String dateReturned)
    {

        this.dateReturned = dateReturned;
    }

    public int getBookId()
    {

        return bookId;
    }

    public void setBookId(int bookId)
    {

        this.bookId = bookId;
    }

}
