package com.example.libary;


public class Libary {

    private Book [] books = new Book[10];
    private Member [] members = new Member[10];
    private Loan [] loans = new Loan[10];

    private int bookCounter = 0;
    private int memberCounter = 0;
    private int loanCounter = 0;

    public int getBookCounter() {
        return bookCounter;
    }

    public int getMemberCounter() {
        return memberCounter;
    }

    public int getLoanLenght() {
        return loans.length;
    }

    public int getLoanCounter() {
        return loanCounter;
    }

    public Member getMember(int i) {
        return members[i];
    }
    public Loan getLoan(int i) {
        return loans[i];
    }




    public Book findBookByIsbn(int isbn) {

        for (int i = 0; i < bookCounter; i++){

            if (books[i].isbn() == isbn) {
                return books[i];
            }
        }
        return null;
    }

    public Book findBookByAuthor (String author) {

        for  (int i = 0; i < bookCounter; i++){

            if (books[i].author().equalsIgnoreCase(author)){
                return books[i];
            }
        }
        return null;
    }

    public Book findBookByTitle (String title) {


        for (int i = 0; i < bookCounter; i++){

            if (books[i].title().equalsIgnoreCase(title)){
            return books[i];
            }
        }
        return null;
    }

    public void sortBooks() {

        for  (int i = 0; i < bookCounter; i++){
            for (int j = i + 1; j < bookCounter; j++){
                if (books[i].title().compareToIgnoreCase(books[j].title()) > 0){
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

    public void sortMembersMostLoans() {
        for   (int i = 0; i < memberCounter; i++) {
            for (int j = 0; j < loanCounter; j++) {
                int loanCounti = 0;
                int loanCountj = 0;

                    for (int k = 0; k < loanCounter; k++) {
                        if (loans[k].getMember().equals(members[i])) {
                            loanCounti++;}
                        if (loans[k].getMember().equals(members[j])) {
                            loanCountj++;
                        }

                    }
                if (loanCounti < loanCountj) {
                    Member temp = members[j];
                    members[j] = members[i];
                    members[j] = temp;
                }

            }

        }
    }

    public boolean addBook(Book book) {


        if (findBookByIsbn(book.isbn()) != null){
            return false;
        }
        if (bookCounter >= books.length){
            return false;
        }
        books[bookCounter] = book;
        bookCounter++;
        return true;
    }
    
    public Member findMember(String username) {
        for (int i = 0; i < memberCounter; i++) {
            if (members[i].getUsername().equalsIgnoreCase(username)) {
                return members[i];
            }
        }
        return null;
    }
    
    public void addMember(Member member) {



        if (memberCounter >= members.length){
            IO.println("There is no more space in the libary for new members.");
            return;
        }
        members[memberCounter] = member;
        memberCounter++;
    }

    public Loan findLoan(Book book) {
        for (int i = 0; i < loanCounter; i++){

            if (loans[i].getBook().isbn() == book.isbn()){
                return loans[i];
            }
        }
        return null;
    }

    public Loan findLoanByMember(String member) {

        for (int i = 0; i < loanCounter; i++){
            if (member.equalsIgnoreCase(loans[i].getMember().getUsername())){
                return loans[i];
            }
        }
        return null;
    }


    public void borrowBook(Loan loan){


        loans[loanCounter] = loan;
        loanCounter++;
    }

   public void returnBook(String username, String title){

        for (int i = 0; i < loanCounter; i++){

            if (loans[i].getMember().getUsername().equalsIgnoreCase(username) &&
                   loans[i].getBook().title().equalsIgnoreCase(title)){
                for (int j = i; j < bookCounter; j++){
                loans[j] = loans[j + i];
                }

                loans[loanCounter - 1] = null;
                loanCounter--;
            }

        }
   }

public Book getBook(int i){
        return books[i];
}

   public boolean isBorrowed(Book book){

       for (int i = 0; i < loanCounter; i++){
           if (loans[i].getBook().isbn() == books[i].isbn()){
             return true;
           }
       }
    return  false;
   }

    //Change size of possible loans/books/members (arrays)!!

    //Login menu( admin/user)

}

