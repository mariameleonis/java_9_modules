package com.banking.dto;

import java.time.LocalDate;

public class Subscription {

  String bankCard;
  LocalDate startDate;

  public String getBankCard() {
    return bankCard;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setBankCard(String bankCard) {
    this.bankCard = bankCard;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  @Override
  public String toString() {
    return "Subscription{" +
        "bankCard='" + bankCard + '\'' +
        ", startDate=" + startDate +
        '}';
  }
}
