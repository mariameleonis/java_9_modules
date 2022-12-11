package com.baeldung.modules.banking.service;

import com.baeldung.modules.banking.dto.BankCard;
import com.baeldung.modules.banking.dto.Subscription;
import com.baeldung.modules.banking.dto.User;
import java.util.List;
import java.util.Optional;

public interface ServiceInterface {

  void subscribe(BankCard card);

  Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);

  List<User> getAllUsers();

}
