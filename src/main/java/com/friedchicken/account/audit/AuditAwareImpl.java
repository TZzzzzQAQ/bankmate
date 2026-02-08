package com.friedchicken.account.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    /**
     * @return Return the auditor of the application
     */
    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Account_MS");
    }
}
