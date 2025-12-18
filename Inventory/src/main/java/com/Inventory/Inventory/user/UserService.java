package com.Inventory.Inventory.user;

import com.Inventory.Inventory.core.BaseRepository;
import com.Inventory.Inventory.core.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, Long> {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<User, Long> getRepository() {
        return repository;
    }

    @Override
    protected String getEntityName() {
        return "User";
    }
}
