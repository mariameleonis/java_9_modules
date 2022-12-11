package com.baeldung.modules.banking.bank.impl;

import com.baeldung.modules.banking.bank.BankInterface;
import com.baeldung.modules.banking.dto.User;
import com.baeldung.modules.banking.dto.BankCard;
import com.baeldung.modules.banking.dto.BankCardType;
import com.baeldung.modules.banking.dto.CreditBankCard;
import com.baeldung.modules.banking.dto.DebitBankCard;
import java.util.concurrent.ThreadLocalRandom;

public class BankImpl implements BankInterface {

  @Override
  public BankCard createBankCard(User user,
      BankCardType cardType) {
    BankCard bankCard;
    if (cardType == BankCardType.CREDIT) {
      bankCard = new CreditBankCard();
    } else if (cardType == BankCardType.DEBIT) {
      bankCard = new DebitBankCard();
    } else {
      throw new IllegalArgumentException("Unknown bank card type");
    }
    bankCard.setUser(user);
    bankCard.setNumber(generateCardNumber());
    return bankCard;
  }

  private String generateCardNumber() {
    var smallest = 1000_0000_0000_0000L;
    var biggest =  9999_9999_9999_9999L;

    var random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
    return String.valueOf(random);
  }
}
