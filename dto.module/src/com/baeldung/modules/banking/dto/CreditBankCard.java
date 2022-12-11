package com.baeldung.modules.banking.dto;

public class CreditBankCard extends BankCard {

  public CreditBankCard() {
  }

  public CreditBankCard(String number, User user) {
    super(number, user);
  }
}
