package com.baeldung.modules.banking.cloud.service;

import com.baeldung.modules.banking.service.ServiceInterface;
import com.baeldung.modules.banking.dto.BankCard;
import com.baeldung.modules.banking.dto.Subscription;
import com.baeldung.modules.banking.dto.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceImpl implements ServiceInterface {

  private static final List<Subscription> SUBSCRIPTIONS = new ArrayList<>();
  public static final User USER_KELSEY = new User("Kelsey", "Peters", LocalDate.parse("1981-01-01"));
  public static final User USER_CHARLES = new User("Charles", "Brooks",
      LocalDate.parse("1970-02-16"));
  public static final User USER_LISA = new User("Lisa", "Miller", LocalDate.parse("1972-06-04"));
  public static final List<User> USERS = new ArrayList<>(Arrays.asList(USER_KELSEY,
      USER_CHARLES,
      USER_LISA));

  @Override
  public void subscribe(BankCard card) {
   var subscription = new Subscription();
   subscription.setBankCard(card.getNumber());
   subscription.setStartDate(LocalDate.now());
   SUBSCRIPTIONS.add(subscription);
  }

  @Override
  public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
    return SUBSCRIPTIONS.stream()
        .filter(s -> s.getBankCard().equals(bankCardNumber))
        .findFirst();
  }

  @Override
  public List<User> getAllUsers() {
    return USERS.stream()
    .collect(Collectors.toUnmodifiableList());
  }
}
