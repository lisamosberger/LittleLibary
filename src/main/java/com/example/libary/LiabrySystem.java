package com.example.libary;

public class LiabrySystem {

    static Libary libary = new Libary();

    static void main() {

        while(true) {
//translate every output to swedish!
            IO.println("\tWelcome to my little liabry!" +
                    "\n=========================================" +
                    "\n1. Lägg till bok" +
                    "\n2. Registrera medlem" +
                    "\n3. Låna bok" +
                    "\n4. Lämna tillbaka bok" +
                    "\n5. Sök bok" +
                    "\n6. Visa alla böcker och status" +
                    "\ne. Avsluta");

            switch (IO.readln("Choose an option: ")){
                case "1"-> libary.addBook();
                case "2"-> libary.addMember();
                case "3"-> libary.addLoan();
                case "4"-> libary.returnLoan();
                case "5"-> libary.findBook();
                case "6"-> libary.showAllBooks();
                case "e"-> System.exit(0);
                default -> IO.println("Invalid input");
            }

        }
    }
}
