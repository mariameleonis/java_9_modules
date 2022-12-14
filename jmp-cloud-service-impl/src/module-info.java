module com.banking.service.impl {
  requires transitive com.banking.service;
  requires com.banking.dto;
  provides com.banking.service.ServiceInterface with com.banking.service.impl.ServiceImpl;
  exports com.banking.service.impl;
}