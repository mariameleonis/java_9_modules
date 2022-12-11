package com.baeldung.modules.banking.dto;

public class BankCard {

  String number;
  User user;

  public BankCard() {
  }

  public BankCard(String number, User user) {
    this.number = number;
    this.user = user;
  }

  public String getNumber() {
    return number;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
