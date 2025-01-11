# JPA SINGLE TABLE Inheritance

- Parent User 
- Child Instructor,Student 
- Inheritance type SINGLE_TABLE
## Insertion

### Code
- Parent using parent repository
```
User user = new User();
user.setEmail("rrj@gmail.com");
user.setName("Rituraj Jain");
User savedUserByUserRepo = userRepository.save(user);
```
### SQL generated

```
Hibernate: insert into user (email,name,dtype,id) values (?,?,'User',?)
```

### Code
- Child using child repository
```
Instructor instructor = new Instructor();
instructor.setInstructor_rating(4.2);
instructor.setName("Sandeep");
instructor.setEmail("ss@gmail.com");
Instructor savedByInsRepo = instructorRepository.save(instructor);
```
### SQL generated

```
Hibernate: insert into user (email,name,instructor_rating,dtype,id) values (?,?,?,'Instructor',?)
```

### Code
- Child using parent repository
```java
Student student = new Student();
student.setName("Rahul");
student.setEmail("rr@gmail.com");
student.setPsp(99.9);
student.setBatchName("22March");
User savedStuByUserRepo = userRepository.save(student);
```
### SQL generated

```
Hibernate: insert into user (email,name,batch_name,psp,dtype,id) values (?,?,?,?,'Student',?)
```