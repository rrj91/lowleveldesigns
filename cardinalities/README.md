# Cardinalities

## One to Many
### Without "mappedBy"
```
Hibernate: create table category (id bigint not null, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table category_products (category_id bigint not null, products_id bigint not null) engine=InnoDB
Hibernate: create table product (category_id bigint, id bigint not null, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table category_products add constraint UKfdnk3mk70n1rc08vw1cj65kqw unique (products_id)
Hibernate: alter table category_products add constraint FKe9irm5a62pmolhvr468cip3v3 foreign key (products_id) references product (id)
Hibernate: alter table category_products add constraint FKqwkr0l0xbluhhkm7s0c1tg8en foreign key (category_id) references category (id)
Hibernate: alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id)
```

```java
@Entity
public class Product extends BaseModel {
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")//no effect
    private Category category;
}
```
```java
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany
    private List<Product> products;
}
```

## @JoinColumn

- The below query is generated with the following code.
- Both @JoinColumn / MappedBy works similar way.

```sql
Hibernate: create table category (id bigint not null, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB
Hibernate: create table product (category_id bigint, id bigint not null, description varchar(255), name varchar(255), primary key (id)) engine=InnoDB
Hibernate: alter table product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id)
```
```java
@Entity
public class Product extends BaseModel {
    private String name;
    private String description;

    @ManyToOne
    private Category category;
}
```
```java
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "category_id") //maps this attribute to corresponding column in product table
    private List<Product> products;
}
```
### OR Using "mappedBy"

```java
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
    @OneToMany(mappedBy = "category") //maps this attribute to corresponding attribute in product table
    private List<Product> products;
}
```