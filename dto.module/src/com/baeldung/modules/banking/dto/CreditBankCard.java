package com.baeldung.modules.banking.dto;

public class CreditBankCard extends BankCard {

  public CreditBankCard() {
    super();
  }

  public CreditBankCard(String number, User user) {
    super(number, user);
  }
}
