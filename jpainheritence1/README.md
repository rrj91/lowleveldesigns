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

## Get All by User Repo
- Query the table **without** dtype
```
select u1_0.id,u1_0.dtype,u1_0.email,u1_0.name,u1_0.instructor_rating,u1_0.batch_name,u1_0.psp from user u1_0
```
## Get all by student Repo
- Query the table **with** dtype
```
select s1_0.id,s1_0.email,s1_0.name,s1_0.batch_name,s1_0.psp from user s1_0 where s1_0.dtype='Student'
```