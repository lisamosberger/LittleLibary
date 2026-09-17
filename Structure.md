Projekt 1 Libary manager (Planning)

-- Use of the Projekt --

You are going to build an interactive command-line application in Java that manages a small libary: books,
members and loans. The program should run in a loop and display a menu until the user chooses to exit. 

-- What it needs --
Book (record Book (int isbn, String titel, string författaren, String Genre)
Member (class) - int memberId, String name, Int age
Loan (class) - int memberId, int isbn, String loanDate
Libary (class) - Book[] books, Member[] members, Loan[] loans



Structure of the Projekt (Try with undermenuer)
--Menu-- 
   Välkommna till vårt hemsida på 
Little Libary's Bibliotekshanteraren! 
=================================================== 

1. Sign Up 
2. Log in 
3. Book list 
e. Exit 
Choose an option 

Sign up ------>
Press 1 for admin permissions and 2 for user permissions (tilldela till user klassen or admin klassen)
Username: 
Password:


(This will add a new Member in the memberclass, controll no dubble username!)

Log in ----->
Name: 
Password
(This will make it possible to go to the users menu of a specific user/ or admin with more permissions)

Username
1. Borrow a book 
2. List with borrowed books 
3. Give back a book 
4. Booklist and status of all books 
5. Search for a book (Title, författaren, search after genre(List with all possibles genre, if there is no book print 
"No book in this genre is not avaiable"))
6. Log out ---> brings you back to main menu 

Admin (More permissions!)
1. register new book
2. delete book 
3. List with borrowed books 
4. borrow a book 
5. give back a book 
6. member list (all members username and password listet)
7. Booklist and status 
8. Log out 


