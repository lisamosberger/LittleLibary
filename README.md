# Lab 1 - Libary Manager (CLI)
This project is a simple command line libary manager written in Java. The program manages books, members and loans. 
The program uses several classes and arrays to store and manage the libary data. 
The program has different menus depending on whether the user is logged in or not. A logged in user can borrow and return books automatically under their own acoount. 
The user can also view their active loans and see on what place he is in the most loan list compared to other users. There is also an admin menu with more functions than the normal 
user menu. For this projekt, the user can choose while creating the account if they want to be an admin or a normal user. As a logged in user or admin they can normally log out to get back
to the main menu. While logging out the loggedInUser resets again to null. The main menu has fewer functions than the logged in menus. From the main menu, the user can simply only acces standart information such as the book list,
search for books and see the member list. 

# Functions
The program contains: 

- Add books
- Register members
- Borrow books
- Return books
- Search for books by title, isbn or author
- Show the members with the most active loans
- Automatically increase array size when full
- Sort books by title
- Show clear error messages if wrong input or not able to find something
- Log in/ Log out
- Show the own loans

All users input get checked to make sure that the entered information exists and the program doesn't crash. Upper and lower case doesn't matter while typing in words as a user. The only 
time it matters is when typing their password incorrectly. The Menu closes first if they log out and exit. 
The Book is a record because its information doesnt need to be changed after creation. It contains fixed variables like ISBN, title and author. The same is for the Loan, in the beginning i 
had loan as a class but when i realised we don't need to change something directly in loans i changed it to a record because it just needs to hold fixed information. 
While Members needed to be a class with private fields, because the information about the members could be changed during the program. 

# G requirements
- [X] Create a Book record with ISBN, title and author
- [X] Explain in ReadMe why Book is a record
- [X] Create Member as a class with private fields
- [X] Create libary as a class that handles all books, members and loans
- [X] Store books, members and loans in arrays
- [X] Handle the situation when an array is full (so it doesn't crash)
- [X] Show the menu in a loop until the user exits
- [X] Handle incorrect menu choices without the program crashing
- [X] Check if numerical input contains valit numbers
- [X] Show clear messages if something doesn't exist or cannot be found.

# VG Requirements
- [X] Create my own sorting algorithm (bubble sort)
- [X] Sort books by title
- [X] Sort members by number of loans
- [X] Do not use streams or colletions
- [X] Create a larger array when an array becomes full
- [X] Extend reflections

# Own Extensions 
- [X] Login and logout
- [X] Admin and user menu
- [X] Admin has more rights than normal user
- [X] connect everything to logged in user

# Limitation of the Collections Framework 
If the Collections Framework were allowed, many things would be shorter and a lot easier. It would be possible to use "Arraylist" instead of a limited array. Which means that it wouldn't 
have been necessery to resize the current array because it would happen automatically. Even the sorting ans searching could be a lot simpler with build in methods. But working without the 
Collection Framework made me understand better how arrays work and how to use them properly. 

# Debugging and Testing
During development i repeatedly testet the program and found new problems, evrytime I fixed something, something new came up. Some errors were easier to notice, while others were harder to find. 
I created a checkIfNumber method to check if the input is correctly and a good number to use before giving it to the real method. 

# Reflection
During this projekt i realised i still need to learn a lot, in the beginning i didn't know where to start and i didn't had any structure in my plan. I focused on the whole program at once, but i realised it
would have been so much easier if i would have focused on one thing at a time. After some time it got more and more structured and i could find everything easier than in the beginning. 
