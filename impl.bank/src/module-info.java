module impl.bank {
    requires transitive bank.api.module;
    requires dto.module;
    exports com.baeldung.modules.banking.bank.impl;
}