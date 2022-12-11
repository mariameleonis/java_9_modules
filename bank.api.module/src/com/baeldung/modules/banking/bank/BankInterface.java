package com.baeldung.modules.banking.bank;

import com.baeldung.modules.banking.dto.BankCard;
import com.baeldung.modules.banking.dto.BankCardType;
import com.baeldung.modules.banking.dto.User;

public interface BankInterface {

  BankCard createBankCard(User user, BankCardType cardType);

}
