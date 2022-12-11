module banking.app {
  requires dto.module;
  requires impl.bank;
  requires cloud.service.module;
  requires bank.api.module;
  requires service.api.module;
}