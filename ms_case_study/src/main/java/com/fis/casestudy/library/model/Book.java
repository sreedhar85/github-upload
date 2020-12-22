package com.fis.casestudy.library.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book
{
    @Id
    int    bookId;

    String bookName;

    String author;

    long   availableCopies;

    long   totalCopies;

    public int getBookId()
    {

        return bookId;
    }

    public void setBookId(int bookId)
    {

        this.bookId = bookId;
    }

    public String getBookName()
    {

        return bookName;
    }

    public void setBookName(String bookName)
    {

        this.bookName = bookName;
    }

    public String getAuthor()
    {

        return author;
    }

    public void setAuthor(String author)
    {

        this.author = author;
    }

    public long getAvailableCopies()
    {

        return availableCopies;
    }

    public void setAvailableCopies(long availableCopies)
    {

        this.availableCopies = availableCopies;
    }

    public long getTotalCopies()
    {

        return totalCopies;
    }

    public void setTotalCopies(long totalCopies)
    {

        this.totalCopies = totalCopies;
    }

}
