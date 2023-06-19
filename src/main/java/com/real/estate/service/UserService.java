
package com.real.estate.service;

import com.real.estate.entity.User;

public interface UserService {
    User addUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
}
