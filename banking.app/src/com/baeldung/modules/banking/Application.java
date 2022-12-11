package com.baeldung.modules.banking;

import static com.baeldung.modules.banking.cloud.service.ServiceImpl.USERS;
import static com.baeldung.modules.banking.cloud.service.ServiceImpl.USER_CHARLES;
import static com.baeldung.modules.banking.cloud.service.ServiceImpl.USER_KELSEY;
import static com.baeldung.modules.banking.cloud.service.ServiceImpl.USER_LISA;

import com.baeldung.modules.banking.bank.impl.BankImpl;
import com.baeldung.modules.banking.cloud.service.ServiceImpl;
import com.baeldung.modules.banking.dto.BankCard;
import com.baeldung.modules.banking.dto.BankCardType;
import com.baeldung.modules.banking.dto.CreditBankCard;
import com.baeldung.modules.banking.dto.DebitBankCard;
import com.baeldung.modules.banking.dto.Subscription;
import com.baeldung.modules.banking.dto.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

  public static final Scanner SCANNER = new Scanner(System.in);
  public static final List<BankCard> CARDS = new ArrayList<>(
      Arrays.asList(
          new DebitBankCard("1111", USER_CHARLES),
          new CreditBankCard("2222", USER_LISA),
          new DebitBankCard("3333", USER_KELSEY)));

  public static void main(String[] args) {
    var sc = SCANNER;
    int ch;

    do {
      System.out.println("***Welcome to Banking System Application!***");
      System.out.println(
          "1. Create bank card \n2. Search subscription by Card number\n3. Subscribe bank card \n4. Get all users \n5.Exit ");
      System.out.println("Enter your choice: ");
      ch = sc.nextInt();

      switch (ch) {
        case 1:
          createBankCard();
          break;
        case 2:
          System.out.print("Enter bank card no. you want to search: ");
          String card_no = sc.next();


            var found = getSubscriptionByCardNumber(card_no);
            if (found.isPresent()) {
              showSubscriptionDetails(found.get());
              break;
            }

          if (found.isEmpty()) {
            System.out.println("Search failed! Subscription doesn't exist..!!");
          }
          break;
        case 3:
          System.out.print("Enter Bank Card no. : ");
          card_no = sc.next();
          subscribeBankCard(card_no);
          break;
        case 4:
          getUsers();
          break;
        case 5:
          System.out.println("See you soon...");
          break;
      }
    }
    while (ch != 5);

  }

  private static void getUsers() {
    USERS.forEach(user -> System.out.println(user.toString()));
  }

  private static void subscribeBankCard(String card_no) {
    var bankCard = CARDS.stream()
        .filter(card -> card.getNumber().equals(card_no))
        .findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown card"));
    var service = new ServiceImpl();
    service.subscribe(bankCard);
    System.out.println("Subscription was successfully created!");
  }

  private static void showSubscriptionDetails(Subscription found) {
    System.out.println("Subscription starts: " + found.getStartDate());
  }

  private static Optional<Subscription> getSubscriptionByCardNumber(String card_no) {
    var service = new ServiceImpl();
    return service.getSubscriptionByBankCardNumber(card_no);
  }

  private static void createBankCard() {

    System.out.println("Enter your name: ");
    var name = SCANNER.next();
    System.out.println("Enter your surname: ");
    var surname = SCANNER.next();
    System.out.println("Enter your birthday (YYYY-mm-dd): ");
    var birthday = SCANNER.next();
    System.out.println("1. Debit \n2. Credit");
    var cardType = SCANNER.nextInt();
    BankCardType type;
    if (cardType == 1) {
      type = BankCardType.DEBIT;
    } else if (cardType == 2) {
      type = BankCardType.CREDIT;
    } else {
      throw new IllegalArgumentException("Unknown bank card type");
    }
    var bank = new BankImpl();
    var user = new User(name, surname, LocalDate.parse(birthday));
    USERS.add(user);
    var result = bank.createBankCard(user, type);
    CARDS.add(result);
    System.out.println("You successfully created new " + type.name() + " bank card. \nYour card no. " + result.getNumber());
  }
}


