# JPA JOINED Inheritance

- Parent User 
- Child Instructor,Student 
- Inheritance type JOINED
## Insertion
- Each child insertion does two insert queries to update two table
- One user and one child

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
insert into user (email,name,id) values (?,?,?)
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
insert into user (email,name,id) values (?,?,?)
insert into instructor (instructor_rating,id) values (?,?)
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
insert into user (email,name,id) values (?,?,?)
insert into student (batch_name,psp,id) values (?,?,?)
```

## Get All by User Repo
- Query the table with left joins
```
select u1_0.id,
case 
    when u1_1.id is not null then 1 
    when u1_2.id is not null then 2 
    when u1_0.id is not null then 0 
end,
u1_0.email,u1_0.name,u1_1.instructor_rating,u1_2.batch_name,u1_2.psp from user u1_0 
left join instructor u1_1 on u1_0.id=u1_1.id 
left join student u1_2 on u1_0.id=u1_2.id
```
## Get all by student Repo
- Query the table withh join
```
select s1_0.id,s1_1.email,s1_1.name,s1_0.batch_name,s1_0.psp 
from student s1_0 
join 
user s1_1 on s1_0.id=s1_1.id
```