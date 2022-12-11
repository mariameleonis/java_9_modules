module banking.app {
  requires dto.module;
  requires impl.bank;
  requires cloud.service.module;
  uses com.baeldung.modules.banking.bank.BankInterface;
  uses com.baeldung.modules.banking.service.ServiceInterface;
}