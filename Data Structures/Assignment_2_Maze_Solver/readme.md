# Assignment 2 - Maze Solver

This project was completed as part of the Data Structures course at NSCC. The goal of the project was to build an application to demonstrate the use of stacks would be able to solve mazes of a certain format and line editing. The program functions by reading in a text file provided as arguments and determines the correct path from a fixed starting point to a fixed ending point. After the correct path has been found through the maze a text file is produced containing the original maze with the correct path marked throughout.

The biggest challenges in writing this application was coming up with a suitable method to solve the maze, storing/processing the text file and working with the maze. The maze solving algorithm operates by searching for available directions until the end of the maze is reached. Each time the method encounters a dead-end it removes entries from the stack until a free direction becomes available.

Additionally, a strong knowledge of the basics of pointers were required to handle processing the array; the assignment specifications denied us the use of standard library string to hold and process the maze data.

The main classes of the application are an array based stack implementation, a simple struct to hold cell information and a class responsible for solving the maze.

![alt tag](http://michaelpratt.ca/images/maze.png)
