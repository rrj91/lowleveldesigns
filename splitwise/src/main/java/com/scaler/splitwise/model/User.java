package com.scaler.splitwise.model;

import jakarta.persistence.*;


import java.util.List;

@Entity(name = "splitwise_user")
public class User extends BaseModel {
    private String name;
    private String phone;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<UserExpense> userExpenses;
    @ManyToMany(mappedBy = "users")
    private List<Group> groups;
    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

    public User() {
    }

    public User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.phone = userBuilder.phone;
        this.email = userBuilder.email;
        this.userExpenses = userBuilder.userExpenses;
        this.groups = userBuilder.groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserExpense> getUserExpenses() {
        return userExpenses;
    }

    public void setUserExpenses(List<UserExpense> userExpenses) {
        this.userExpenses = userExpenses;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }
    public static class UserBuilder{
        private String name;
        private String phone;
        private String email;
        private List<UserExpense> userExpenses;
        private List<Group> groups;

        public UserBuilder name(String name){
            this.name = name;
            return this;
        }
        public UserBuilder phone(String phone){
            this.phone = phone;
            return this;
        }
        public UserBuilder email(String email){
            this.email = email;
            return this;
        }
        public UserBuilder groups(List<Group> groups){
            this.groups = groups;
            return this;
        }
        public UserBuilder userExpenses(List<UserExpense> userExpenses){
            this.userExpenses = userExpenses;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
