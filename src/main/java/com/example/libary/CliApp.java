package com.example.libary;

public class CliApp {

    static Libary libary = new Libary();

    static void main() {


        while (true) {
//translate every output to swedish!
            IO.println("\tWelcome to my little liabry!" +
                    "\n=========================================" +
                    "\n1. Lägg till bok" +
                    "\n2. Registrera medlem" +
                    "\n3. Låna bok" +
                    "\n4. Lämna tillbaka bok" +
                    "\n5. Sök bok" +
                    "\n6. Visa alla böcker och status" +
                    "\n7. Visa Top Loan member" +
                    "\ne. Avsluta");

            switch (IO.readln("Choose an option: ")) {
                case "1" -> addBook();
                case "2" -> addMember();
                case "3" -> borrowBook();
                case "4" -> returnBook();
                case "5" -> findBook();
                case "6" -> showAllBooks();
                case "7" -> showAllMembers();
                case "e" -> System.exit(0);
                default -> IO.println("Invalid input");
            }

            IO.readln("Press Enter to continue...");

        }

    }

    static void findBook() {
        IO.println("Find Book by: " +
                "\n1. Title" +
                "\n2. Author" +
                "\n3. ISBN");

        String choice = IO.readln("Choose an option: ");

        switch (choice) {
            case "1" -> findBookByTitle();
            case "2" -> findBookByAuthor();
            case "3" -> findBookByIsbn();
            default -> IO.println("Invalid input");

        }
    }

    static void printBook(Book book) {

        IO.println("Title: " + book.title() +
                "\nAuthor: " + book.author() +
                "\nISBN: " + book.isbn());

    }

    static int checkIfNumber(String input) {

        if (input.equals("") || input.length() > 9) {
            return -1;
        }


        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return -1;
            }
        }
        return Integer.parseInt(input);
    }


    static void findBookByIsbn() {
        String input = IO.readln("Enter ISBN: ");
        int isbn = checkIfNumber(input);

        Book book = libary.findBookByIsbn(isbn);

        if (book == null) {
            IO.println("Invalid input");
            return;
        }

        printBook(book);

    }

    static void findBookByTitle() {
        String title = IO.readln("Enter title: ");

        Book book = libary.findBookByTitle(title);

        if (book == null) {
            IO.println("Invalid input");
            return;
        }

        printBook(book);

    }

    static void findBookByAuthor() {
        String author = IO.readln("Enter author: ");

        Book book = libary.findBookByAuthor(author);

        if (book == null) {
            IO.println("Invalid input");
            return;
        }

        printBook(book);

    }

    static void addBook() {
        String input = IO.readln("Enter ISBN: ");
        int isbn = checkIfNumber(input);
        if (isbn == -1) {
            IO.println("Invalid input");
            return;
        }
        if (libary.findBookByIsbn(isbn) != null) {
            IO.println("Book already exists");
            return;
        }
        String title = IO.readln("Enter Title: ");
        String author = IO.readln("Enter Author: ");


        Book book = new Book(isbn, title, author);

        if (libary.addBook(book)) {
            IO.println("Book added successfully!");
        } else {
            IO.println("Book could not be added!");
        }
    }

    static void showAllBooks() {

        libary.sortBooks();

        for (int i = 0; i < libary.getBookCounter(); i++) {

            Book book = libary.getBook(i);
            printBook(book);

            Loan loan = libary.findLoan(book);

            if (loan != null) {
                IO.println("Borrowed by: " + libary.findLoan(book).member().getUsername());
            } else {
                IO.println("The Book is available!");
            }
        }

    }

    static void borrowBook() {
        showAllBooks();

        String title = IO.readln("Which book do you want to borrow: "+
                "Name it by title: ");

        Book book = libary.findBookByTitle(title);

        if (book == null){
            IO.println("Book not found!");
            return;
        }

        String username = IO.readln("Enter Username: ");
        Member member = libary.findMember(username);

        if (member == null){
            IO.println("Member not found!");
            return;
        }

        if (libary.findLoan(book) != null){
            IO.println("This Book is already borrowed!");
            return;
        }
        else if (libary.getLoanCounter() >= libary.getLoanLenght()){
            IO.println("There is no more space in the libary for new loan.");
            return;
        }

        Loan loan = new Loan(book, member);
        libary.borrowBook(loan);
        IO.println("You borrowed the book successfully!");
    }

    static void returnBook() {

        String username = IO.readln("Enter your username: ");

        if (libary.findMember(username) == null) {
            IO.println("This user does not exist!");
            return;
        }


        IO.println("Your Loan List:" +
                "\n============================");
        Loan loanByMember = libary.findLoanByMember(username);

        if (loanByMember == null) {
            IO.println("This user has no Borrowed Books!");
            return;
        }

        for (int i = 0; i < libary.getLoanCounter(); i++) {
            IO.println("Loan: " + loanByMember.book().isbn() +
                    "\nTitle: " + loanByMember.book().title() +
                    "\nAuthor: " + loanByMember.book().author());
        }
        String title = IO.readln("Which book do you want to return? Name title: ");

        boolean returned = libary.returnBook(username,title);
        if (libary.findBookByTitle(title) == null) {
            IO.println("The book does not exist!");
        }
        else if (!returned) {
            IO.println("The book is not borrowed by you!");
        }
        else if (returned) {
            IO.println("Book returned successfully!");
        }

    }

    static void addMember(){

        String username = IO.readln("Enter username: ");
        if (libary.findMember(username) != null) {
            IO.println("Member already exists!");
            return;
        }
        String password = IO.readln("Enter password: ");
        String admin = IO.readln("Enter y for admin n for user: ");
        Boolean a;
        if (admin.equals("y") ) {
            a = true;
        }
        else if (admin.equals("n") ) {
            a = false;
        }
        else {
            IO.println("Invalid input!");
            return;
        }

        Member member = new Member(username, password, a);

        libary.addMember(member);
    }

    static void showAllMembers() {
        libary.sortMembersMostLoans();

        IO.println("Members with most Loans" +
                "\n==================================");
        for (int i = 0; i < libary.getMemberCounter(); i++) {
            Member member = libary.getMember(i);
            int loanCount = libary.getLoanCount(member);

            IO.println((i + 1) + ". " +
                    member.getUsername() +
                    " has this many loans: " + loanCount );
        }
    }


}
