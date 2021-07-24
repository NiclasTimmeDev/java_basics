# Golf round statistics generator

## What's inside?

The program takes a CSV file that contains statistics about a round of golf played. It then calculates KPIS (statistics) of the round that the player can use to determine his/her strengths and weaknesses. Specifically, the program computes:
* The score & how much the player was under/over par
* The number of putts
* The percentage of fairways hit
* The percentage of greens in regulation
* The percentage of Up and downs

The results are displayed in nice colours in the terminal.

## How to use it

In `com.golf_stats.Main` enter the path to the CSV file that contains the data of your golf round. The file must be formatted the following way:
* Each row of the CSV file contains data for one hole of the round
* The columns (from first to last) must contain the following data:
    * Number of the hole (1-18)
    * Par of the hole (3-5)
    * The score you made on the hole
    * The number of putts you made on that hole
    * If you hit the fairway on that hole (1= Fairway hit, 0 = Fairway missed). If it's a par three you can enter anything you want as the data will not be used in the computation. However, please don't leave the value emtpy.
    * If you hit the green in regulation on that hole (1 = green hit, 0 = green missed).
    * If you made an up and down on that hole (1= Up and down made, 0 = Up and down missed). II you hit the green in regulation and didn't have to make a chip/pitch you can enter anything you want as the data will not be used in the computation. However, please don't leave the value emtpy.
    
## What I learned
This was my first Java project so basically everything in the project was new for me. But apart from the basic programming concepts I knew from other programming lanugages I learned:
* The basics of OOP in Java
* Packages
* Working with lists and arrays
* Handling exceptions
* Reading CSV files
* Printing colored statements to the console