module com.banking.api.impl {
    requires transitive com.banking.api;
    requires com.banking.dto;
    provides com.banking.api.BankInterface with com.banking.api.impl.BankImpl;
    exports com.banking.api.impl;
}