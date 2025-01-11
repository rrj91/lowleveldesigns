# JPA TABlE_PER_CLASS Inheritance

- Parent User 
- Child Instructor,Student 
- Inheritance type TABlE_PER_CLASS

## Working
- Creates separate tables for each entity i.e Parent and All its child
- All the parent attributes are copied to each of child tables
- In our case three tables User,Instructor and Student created

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
Hibernate: insert into user (email,name,id) values (?,?,?)
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
Hibernate: insert into instructor (email,name,instructor_rating,id) values (?,?,?,?)
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
Hibernate: insert into student (email,name,batch_name,psp,id) values (?,?,?,?,?)
```
## Get All by UserRepo
- Taken union of all three tables
```
select u1_0.id,u1_0.clazz_,u1_0.email,u1_0.name,u1_0.instructor_rating,u1_0.batch_name,u1_0.psp from (
select id, email, name, null as instructor_rating, null as psp, null as batch_name, 0 as clazz_ from user 
union all 
select id, email, name, instructor_rating, null as psp, null as batch_name, 1 as clazz_ from instructor 
union all 
select id, email, name, null as instructor_rating, psp, batch_name, 2 as clazz_ from student) u1_0
```
## Get all by studentRepo
- Taken only from student's table
```
select s1_0.id,s1_0.email,s1_0.name,s1_0.batch_name,s1_0.psp from student s1_0
```