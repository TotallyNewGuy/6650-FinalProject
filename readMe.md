
**How to run this project.**

We have already deploy our Zookeeper servers, kafka service, dubbo serive, seata serive to server. So to run this project, you can simply run our jar files. 

0. To run this project, please make sure your java version is 1.08
1. Go to ../6650-jar/, where you can see all jar files from A to E stage. open one terminal to run each jar file. You must run jar files sequentially from A to E satge. Wait all jar files in one stage (say jar files start with C) fully loaded (the log pause) and open jar files in next stage (say jar files starts with D). Detailed steps are as follows: 
2. in a terminal, run ```java -jar A-dubbo.jar ```. wait until it is fully loaded(the log at terminal pause)
3. in a terminal, run ```java -jar B-config-service.jar``` . wait until it is fully loaded(the log at terminal pause)
4. open 6 terminals, run one of the command in each terminal.
```
   java -jar C-book-service1.jar
   java -jar C-book-service2.jar
   java -jar C-book-service3.jar
   java -jar C-user-service1.jar
   java -jar C-user-service2.jar
   java -jar C-user-service3.jar
```
 wait until all is fully loaded(the log at terminal pause).
5. in a terminal, run ```java -jar D-order-service.jar``` . wait until it is fully loaded(the log at terminal pause)
6. in a terminal, run ```java -jar E-purchase-service.jar``` . wait until it is fully loaded(the log at terminal pause)

Now you can interact with our APIs on web browser. copy paste the Example to browser and wait for http results.   
PURCHASE SERVICE （PORT: 6800） \
/purchase \
Purchase requests will be generated based on the user's ID(userId), book ID(bookId) and the quantity of the book(cnt). \
Example: http://localhost:6800/purchase?userId=1&bookId=2&cnt=3 \
This means the user with an ID 1 wants to buy 3 books with ID 2. If the user purchases successfully, the server will return user1’s order history. 

USER SERVICE: （PORT: 6500/ 6502/ 6503） \
/user/balance/check \
To check the user’s current balance on the account. \
Example: http://localhost:6500/user/balance/check?id=1  \
To check the current balance of the user with ID 1. 

/user/balance/subtract \
To reduce the user's balance. Parameters should be the user's id(id) and the amount that will be subtracted(num). \
Example: http://localhost:6500/user/balance/subtract?id=1&num=5 \
To subtract 5 from the account of the user with ID 1. 

/user \
To check the user's basic information: name, address. \
Example: http://localhost:6500/user/1 \
To check information of user with ID 1 

BOOK SERVICE:（PORT: 6600/ 6602/ 6603）\
/book/{id}\
To check the basic information of a book with the book id. \
Example: http://localhost:6600/book/1
Get the information of the book with id 1. 

/stock/check \
To check the number of a book with a certain id in the inventory. \
Example: http://localhost:6600/stock/check?id=1 \
Get the number of the book with id 1 in inventory. 

/stock/subtract \
To reduce the book’s inventory. The parameters are the book's id and the amount to be subtracted. \
Example: http://localhost:6600/stock/subtract?id=1&num=5 \
To subtract 5 from the inventory of books with id 1. 

ORDER SERVICE （PORT: 6700） \
/order/all \
To get all the orders. \
Example: http://localhost:6700/order/all 

/order/{id} \
To get all the orders of a user with a certain ID. The parameter is userid.\
Example: http://localhost:6700/order/1 \
Get all the orders of the user with id 1. 

/order/add \
To add an order based on user’s id(userId), book’s id(bookId) and the number of books(cnt). \
Example: http://localhost:6700/order/add?userId=1&bookId=2&cnt=3 \
To add an order, a user with ID wants to buy 3 books with book id 2. 

/order/delete \
To delete an order based on orderId. The parameter is orderId. \
Example: http://localhost:6700/order/delete?orderId=1
Delete the order with orderId 3. 

TEST GROUP COMMUNICATION （PORT: 6500/ 6600/ 6700/ 6800）\
You can test the github version server without adding any suffix.  You can change the configuration information through github.\
Github: TotallyNewGuy/6650demo_config (github.com): https://github.com/TotallyNewGuy/6650demo_config \
It is better to only update the version information. And then you can use the postman to send a POST request to update the configuration. \
localhost:6400/actuator/busrefresh  
After that, you can go to the corresponding port to refresh and then you should be able to see the update. No suffix should be added after the port link.\
Example: http://localhost:6600, http://localhost:6700



