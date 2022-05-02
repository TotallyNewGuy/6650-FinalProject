
How to run this project.
We have already deploy out Zookeeper servers, kafka service, dubbo serive, seata serive to server. So to run this project, you can simply run our jar files. 
0. To run this project, please make sure your java version is 1.08
1. Go to ../6650-jar, where you can see all jar files from A to E stage. open one terminal to run each jar file. You must run jar files sequentially from A to E. Wait all jar files in one stage (say jar files start with C)fully loaded(the log pause) and open jar files in next stage(say jar files starts with D). Detailed steps are as follows: 
2. in a terminal, run java -jar A-dubbo.jar . wait until it is fullt loaded(the log at terminal pause)
3. in a terminal, run java -jar B-config-service.jar . wait until it is fullt loaded(the log at terminal pause)
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
5. in a terminal, run java -jar D-order-service.jar . wait until it is fully loaded(the log at terminal pause)
6. in a terminal, run java -jar E-purchase-service.jar . wait until it is fully loaded(the log at terminal pause)

Now you can interact with the project on web browser. For example: 
test purchase service: 
Example: http://localhost:6800/purchase?userId=1&bookId=2&cnt=3
test order delete: 
Example: http://localhost:6700/order/delete?orderId=1
