package com.Inventory.Inventory.auditLog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogService {

    private final AuditLogRepository repository;

    public void log(String action, String entityName, Object entityId, String message) {

        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setEntityName(entityName);
        log.setEntityId(entityId != null ? Long.valueOf(entityId.toString()) : null);
        log.setMessage(message);
        log.setPerformedBy("SYSTEM");

        repository.save(log);
    }

    public List<AuditLog> getAll() {
        List<AuditLog> auditLogs = repository.findAll();
        return auditLogs;
    }
}
