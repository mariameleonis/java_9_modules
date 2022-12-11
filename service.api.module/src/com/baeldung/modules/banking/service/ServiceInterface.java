package com.baeldung.modules.banking.service;

import com.baeldung.modules.banking.dto.BankCard;
import com.baeldung.modules.banking.dto.Subscription;
import com.baeldung.modules.banking.dto.User;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ServiceInterface {

  void subscribe(BankCard card);

  Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);

  List<User> getAllUsers();

  static boolean isPayableUser(User user) {
    return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()) >= 18L;
  }

  default double getAverageUsersAge(){
    return getAllUsers().stream()
        .collect(Collectors.averagingLong(user ->  ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now())));
  }
}
