# Make Change Project

## Description
This is my very first Java project while at Skill Distillery. The application acts as a cash register, requesting input from the cashier on the cost of the item and the amount of money tendered by the customer. Upon receipt of those two inputs, the program provides a change denomination to the cashier (only using $20 bills and smaller, down to pennies). If money tendered is exact or too small, the program provides feedback saying so. Otherwise, the program tells the cashier what bill and coin combinations to provide to the customer. 

At completion of the transaction, the cashier is asked if there are other customers. If yes, the program runs again, if no, the program closes.

## What I learned
I'm really satisfied with my thought processes on this project, although I'm sure it could have been more streamlined (when I look at this in a week or two or more I'll probably laugh). My biggest learning moment was about inaccuracies in Java's math function and how to handle them by using int rather than double. The inaccuracies are small (1 - 0.67 = 0.329999999 in Java while it should equal 0.33 repeating) but often caused the penny counter to be off by one. 

I still need to learn how to pass variables between methods. I have a hunch that declaring a bunch of static variables above the main method isn't best practice.

## Technologies Used
Java, Eclipse, Git
