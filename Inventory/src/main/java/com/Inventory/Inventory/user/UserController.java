package com.Inventory.Inventory.user;

import com.Inventory.Inventory.core.BaseController;
import com.Inventory.Inventory.core.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController<User, Long> {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    protected BaseService<User, Long> getService() {
        return service;
    }
}

