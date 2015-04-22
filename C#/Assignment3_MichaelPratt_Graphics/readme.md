This project was the third assignment for Advanced OOP. The assignment was open ended and allowed each student to create a game of their choice. I chose to create the classic "Snake" or "Caterpillar" game.

The user starts with control of the snake's head, and must collect mouse blocks (food) in order to grow. Once the snake eats a mouse, it gains 1 tail piece and the player must collect 20 mouse tails in order to win the game. There are 3 difficulties (easy, medium, and hard) which provide the user a smaller board, and a faster snake depending on how high the difficulty is. If the user crashes into their tail, or into a wall, they lose the game.

The main classes of the project are the snake head itself, the tail objects, a random food generator, and the board. The rendering of the board and its components onto the form is handled by a separate rendering class.

Some of the main challenges of this program were the development of the board. Having the food blocks being a precise size, and having my snake objects needing to line up perfectly became a struggle. I needed to use magic numbers in order how have my food block line up perfectly with the edges, and allow the game to look in uniform.

![alt tag](http://michaelpratt.ca/images/snake.png)
