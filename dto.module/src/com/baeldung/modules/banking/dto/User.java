package com.baeldung.modules.banking.dto;

import java.time.LocalDate;

public class User {

  String name;
  String surname;
  LocalDate birthday;

  public User(String name, String surname, LocalDate birthday) {
    this.name = name;
    this.surname = surname;
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", birthday=" + birthday +
        '}';
  }

  public LocalDate getBirthday() {
    return birthday;
  }
}
