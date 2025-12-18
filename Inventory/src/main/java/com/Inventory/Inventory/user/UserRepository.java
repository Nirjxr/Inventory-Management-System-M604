package com.Inventory.Inventory.user;

import com.Inventory.Inventory.core.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

}
