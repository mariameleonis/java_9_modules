package com.banking.api;

import com.banking.dto.BankCard;
import com.banking.dto.BankCardType;
import com.banking.dto.User;

public interface BankInterface {

  BankCard createBankCard(User user, BankCardType cardType);

}
