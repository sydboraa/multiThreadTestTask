**Multi-Thread Email Sending Simulation**

Program gets users from `receivers.txt file`. This file contains User name, age, email and isActive information.
Person objects are created with these information and stored in a list.

Also, `Application.java` class contains a method named `getSomeEmails()`. This method creates some dummy emails which
contains subject, content and sender.

Now, we are ready to send email.

This program is developed using multi-thread structure. Sending email task is submitted to thread pool.
I used Java Executer interface with a fixed sized thread pool. Code distributes "sending email tasks"
between threads. Executor.invokeAll() executes sending mail tasks and returns Future
when all complete or expire because of some errors.

While sending emails, to simulate network latency I applied random Thread.sleep codes in `EmailService.java`

```java
            /*
            *  I added this code block because, I want to simulate the network latency while sending email.
            * */
            Random random = new Random();
            int randomSleepTime = random.nextInt(200 - 1 + 1) + 1;
            Thread.sleep(randomSleepTime);
            /* end of simulation*/
```


