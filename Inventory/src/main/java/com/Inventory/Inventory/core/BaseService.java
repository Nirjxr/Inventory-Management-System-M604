package com.Inventory.Inventory.core;

import com.Inventory.Inventory.auditLog.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.lang.reflect.Field;
import java.util.List;

public abstract class BaseService<T, ID> {

    protected abstract BaseRepository<T, ID> getRepository();
    protected abstract String getEntityName();

    @Autowired
    private AuditLogService auditLogService;

    public T create(T entity) {
        try {
            T saved = getRepository().save(entity);
            auditLogService.log("CREATE", getEntityName(), getEntityId(saved), "Entity created successfully"
            );
            return saved;
        } catch (Exception e) {
            auditLogService.log("CREATE_FAILED", getEntityName(), null, e.getMessage()
            );
            throw new RuntimeException("Failed to create " + getEntityName(), e);
        }
    }

    public List<T> getAll() {
        try {
            return getRepository().findAll();
        } catch (Exception e) {
            auditLogService.log("FETCH_FAILED", getEntityName(), null, e.getMessage()
            );
            throw new RuntimeException("Failed to fetch " + getEntityName(), e);
        }
    }

    public T getById(ID id) {
        try {
            return getRepository()
                    .findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(getEntityName() + " not found"));
        } catch (ResourceNotFoundException e) {
            auditLogService.log("FETCH_NOT_FOUND", getEntityName(), id, e.getMessage()
            );
            throw e;
        } catch (Exception e) {
            auditLogService.log("FETCH_FAILED", getEntityName(), id, e.getMessage()
            );
            throw new RuntimeException("Failed to fetch " + getEntityName(), e);
        }
    }

    public T update(ID id, T entity) {
        try {
            getById(id);
            T updated = getRepository().save(entity);

            auditLogService.log("UPDATE", getEntityName(), id, "Entity updated successfully"
            );
            return updated;
        } catch (Exception e) {
            auditLogService.log("UPDATE_FAILED", getEntityName(), id, e.getMessage()
            );
            throw new RuntimeException("Failed to update " + getEntityName(), e);
        }
    }

    public void delete(ID id) {
        try {
            getRepository().deleteById(id);
            auditLogService.log("DELETE", getEntityName(), id, "Entity deleted successfully"
            );
        } catch (Exception e) {
            auditLogService.log("DELETE_FAILED", getEntityName(), id, e.getMessage()
            );
            throw new RuntimeException("Failed to delete " + getEntityName(), e);
        }
    }

    protected Object getEntityId(T entity) {
        try {
            Field field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            return field.get(entity);
        } catch (Exception e) {
            return null;
        }
    }
}
