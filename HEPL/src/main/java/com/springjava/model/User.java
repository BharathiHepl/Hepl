package com.springjava.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
//@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    private String name;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    private Set<Role> roles;
    
    public Integer  getId() {
          return id;
      }
      public void setId(Integer  id) {
          this.id = id;
      }
      public String getName() {
          return name;
      }
      public void setName(String name) {
          this.name = name;
      }
      public String getUserName() {
          return userName;
      }
      public void setUserName(String username) {
          this.userName = username;
      }
      public String getEmail() {
          return email;
      }
      public void setEmail(String email) {
          this.email = email;
      }
      public String getPassword() {
          return password;
      }
      public void setPassword(String password) {
          this.password = password;
      }
      public Set<Role> getRoles() {
          return roles;
      }
      public void setRoles(Set<Role> roles) {
          this.roles = roles;
      }
}