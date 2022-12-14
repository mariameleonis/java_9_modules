import com.banking.api.BankInterface;
import com.banking.service.ServiceInterface;

module com.banking.app {
  requires com.banking.dto;
  requires com.banking.api.impl;
  requires com.banking.service.impl;
  uses com.banking.api.BankInterface;
  uses com.banking.service.ServiceInterface;
}