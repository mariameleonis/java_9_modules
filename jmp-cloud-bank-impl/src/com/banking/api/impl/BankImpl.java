package com.banking.api.impl;

import com.banking.api.BankInterface;
import com.banking.dto.BankCard;
import com.banking.dto.BankCardInterface;
import com.banking.dto.BankCardType;
import com.banking.dto.CreditBankCard;
import com.banking.dto.DebitBankCard;
import com.banking.dto.User;
import java.util.concurrent.ThreadLocalRandom;

public class BankImpl implements BankInterface {

  @Override
  public BankCard createBankCard(User user,
      BankCardType cardType) {
//    BankCard bankCard;
//    if (cardType == BankCardType.CREDIT) {
//      bankCard = new CreditBankCard();
//    } else if (cardType == BankCardType.DEBIT) {
//      bankCard = new DebitBankCard();
//    } else {
//      throw new IllegalArgumentException("Unknown bank card type");
//    }
//    bankCard.setUser(user);
//    bankCard.setNumber(generateCardNumber());
//    return bankCard;
    BankCardInterface bankCardInterface;
    var number = generateCardNumber();
    if (cardType.equals(BankCardType.CREDIT)) {
      bankCardInterface = CreditBankCard::new;
    } else {
      bankCardInterface = DebitBankCard::new;
    }
    return bankCardInterface.getBankCard(number, user);
  }

  private String generateCardNumber() {
    var smallest = 1000_0000_0000_0000L;
    var biggest =  9999_9999_9999_9999L;

    var random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
    return String.valueOf(random);
  }
}
