module cloud.service.module {
  requires transitive service.api.module;
  requires dto.module;
  exports com.baeldung.modules.banking.cloud.service;
}