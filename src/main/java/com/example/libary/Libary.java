package com.example.libary;

public class Libary {

    private Book [] books = new Book[10];
    private Member [] members = new Member[10];
    private Loan [] loans = new Loan[10];

    private int bookCounter = 0;
    private int memberCounter = 0;
    private int loanCounter = 0;

    //check if book already exist before adding it with isbn!




    public Book findBook (int isbn) {

        for (int i = 0; i < bookCounter; i++){

            if (books[i].isbn() == isbn) {
                return books[i];
            }
        }
        return null;
    }


    public void addBook(Book book){

        if (findBook(book.isbn()) != null){
            IO.println("Book already exists!");
        }
        if (bookCounter >= books.length){
            IO.println("There is no more space in the libary for new books.");
            return;
        }
        books[bookCounter] = book;
        bookCounter++;
    }

    // find and add Member

    // find and add Loan

    // return Loan

    //show all books (in order)

    //find book by isbn

    //Method for showMemberWithMostLoans

    //Change size of possible loans/books/members

}

