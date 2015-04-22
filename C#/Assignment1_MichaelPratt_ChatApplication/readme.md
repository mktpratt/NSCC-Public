This project was my first look into multi-threaded programming. This program is a multi-threaded TCP chat application which allows a user to both receive and send messages to a running server using the socket classes TcpClient and TcpServer. Multiple threads are required in this application as the actions of sending and receiving a message to or from the server can occur at the same time. In order to maintain responsiveness of the form, we had to notify the user of disconnects and enable instantaneous receiving of messages the program had to design asynchronously.

In addition to receiving and sending messages through the controls on the form a logging mechanism was also added to create time-stamped text files containing the exchange between the server and the user.

The application makes use of several classes. The connection is managed within a client chat class which extends an abstract chat service class . The events and threads tied to receiving a message and sending a message are defined within the form.

![alt tag](http://michaelpratt.ca/images/syncchat.png)

![alt tag](http://michaelpratt.ca/images/syncchat2.png)
