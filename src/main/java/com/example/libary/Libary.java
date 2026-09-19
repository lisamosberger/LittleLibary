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


    public void addBook(){

        int isbn = Integer.parseInt(IO.readln("Enter ISBN: "));
        String title = IO.readln("Enter Title: ");
        String author = IO.readln("Enter Author: ");

        Book book = new Book(isbn, title, author);

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
    
    public Member findMember(String username) {
        for (int i = 0; i < memberCounter; i++) {
            if (members[i].getUsername().equals(username)) {
                return members[i];
            }
        }
        return null;
    }
    
    public void addMember(){

        String username = IO.readln("Enter Username: ");
        String password = IO.readln("Enter Password: ");
        String admin = IO.readln("Are you an admin yes or no (y/n): ");
        boolean a;

            if (admin.equals("y")){
                a = true;
            }
            else if (admin.equals("n")){
                a = false;
            }
            else {
                IO.println("Invalid Input.");
                return;
            }
            Member member = new Member(username, password, a);

        if (findMember(member.getUsername()) != null){
            IO.println("Member already exists!");
        }
        else if (memberCounter >= members.length){
            IO.println("There is no more space in the libary for new members.");
        }
        members[memberCounter] = member;
        memberCounter++;
    }

    public Loan findLoan(Loan loan) {
        for (int i = 0; i < loanCounter; i++){

            if (loans[i].getBook().isbn() == loan.getBook().isbn()){
                return loans[i];
            }
        }
        return null;
    }

    public void addLoan(Loan loan){
        if (findLoan(loan) != null){
            IO.println("This Book is already borrowed!");
        }
        else if (loanCounter >= loans.length){
            IO.println("There is no more space in the libary for new loan.");
        }
        loans[loanCounter] = loan;
        loanCounter++;
    }

   public void returnLoan(Loan loan){
        if (findLoan(loan) == null){
            IO.println("This book is not borrowed!");
        return;
        }
        for (int i = 0; i < loanCounter; i++){
            if (loans[i].getBook().isbn() == loan.getBook().isbn()){
                for (int j = i; j < bookCounter; j++){
                loans[j] = loans[j + i];}
            }
            loans[loanCounter - 1] = null;
            loanCounter--;
            return;
        }
   }


   public void showAllBooks(Book book){
        for (int i = 0; i < bookCounter; i++) {

            IO.println("Book " + (i + 1) + ": " + books[i].title() +
                    "\nISBN: " + books[i].isbn() +
                    "\n Author: " + books[i].author());


            boolean borrowed = false;

            for (int j = 0; j < loanCounter; j++){
                if (loans[j].getBook().isbn() == book.isbn()){
                    borrowed = true;

                    IO.println("Status Borrowed by " +
                            loans[j].getMember().getUsername());
                    break;
                }
            }

            if (!borrowed){
                IO.println("The Book is Avaiable.");
            }

            IO.println("========================================================\n");
        }

   }


    //show all books (in order)

    //find book by isbn

    //Method for showMemberWithMostLoans

    //Change size of possible loans/books/members

}

