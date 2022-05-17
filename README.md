## Discussion Forum
The discussion forum for the SEU Chengxian College, currently supporting posting question, viewing questions, and log in with Github account 

## Demo
![Image text](https://raw.githubusercontent.com/JiaoyangXu/Discussion-Forum/main/pictures/Home-page.png)
![Image text](https://raw.githubusercontent.com/JiaoyangXu/Discussion-Forum/main/pictures/Post-Question.png)

## How to Run

### Install
```
git clone https://github.com/JiaoyangXu/Discussion-Forum.git
```
### Run script to create local database
````
mvn flyway:migrate
````

### Open with Intellij IDEA Utimate and run project.

### Visit site
````
http://localhost:8887
````


## Tech Stack
* [Springboot](http://spring.io/guides)
* [bootstrap](https://v3.bootcss.com/)
* [MyBatis](https://mybatis.org/)
* [H2 database](http://www.h2database.com/html/main.html)
* [Flyway](https://flywaydb.org/getstarted/firststeps/maven)
* [Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app)	

## TO-DO 
- [ ] Add more features
    - [ ] Reply to posts
    - [ ] Star posts and get notifications
    - [ ] Add friends and private chat
    - [ ] Support more login options (Google Account, Wechat)
  
- [ ] Optimize the structure
  - [ ] Replace H2 database with MySQL or Oracle
  - [ ] Separate front-end from the back-end and use React as the framework  

