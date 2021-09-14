# PG5100 Enterprise Exam 2021

### Instruction when starting an IDE for testing the application:

1. Run: mvn clean verify to run all tests and build the project.

2. Run the LocalApplicationRunner who are located in frontend/test/no.kristiania.exam.website/

    * Now the application is available at your browser at http://localhost:8080/
  
## Requirements completed:

I did requirements R1, R2 and partially R3. Did not manage to do R4 and R5

In R3 I have the following functionalities:

* Homepage: display all the items, with info summaries, and links to detail page.
  * NOTE: Items should be sorted by average number of stars. are NOT implemented


* If a user is logged in, then display a welcome message.


* User login/signup page, based on Spring Security and storing of user info on the SQL
  database. It should be possible to logout from any of the pages (e.g., via a button). When a
  login/signup fails, you MUST show an error message.
  


### Backend structure

I have structured the backend entity according to R1 in the exam document.


* User: having info like name, surname, hashed-password, email, etc.
  

* Item: having info like name/title, description, category, etc.
  

* Rank: score 1-to-5 (made by a specific user for a specific item), possibly a comment to the
ranked item, etc.

### Test:

According to Jacoco I have a test coverage in the backend module at 87% test coverage.

The total Coverage with backend and frontend module is 68%.

I do not have selenium test for the frontend module since time ran out.

### Known bugs:

In the DefaultDataInitializerService, I got test failure:
  
    * java.lang.IllegalStateException: Failed to load ApplicationContext

I don't know why this happened, but with removing some rankService.createRank in DefaultDataInitializerService the test ran okay.

I made in total 42 rankService.createRank in DefaultDataInitializerService, and I think was such an overload on the system, so I had to remove some to make the tests run.

You can se that I have commented out this in DefaultDataInitializerService on line 128 - 149
### Source material:

* I have done my best to comment on code I have used in this Exam from the course repo.
  
    * https://github.com/crlsocro/testing_security_development_enterprise_systems

* The pom.xml files are inspired from the course repo. 
  

* Link to info from webpage - used this information to fill the different activities in DefaultDataInitializerService.

* In particular, I used the information from the websites below for the slopes at Tryvann ski resort. 
  I used my imagination on all the other activities, but there are climbing routes on eg Kolsåstoppen and ski routes in Nordmarka that I know of.
  
  * https://en.wikipedia.org/wiki/Tryvann_Ski_Resort
  
  * https://www.skiresort.info/ski-resort/oslo-tryvann-skimore/