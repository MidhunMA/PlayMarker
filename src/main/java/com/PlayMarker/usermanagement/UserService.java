package com.PlayMarker.usermanagement;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
    User updateUser(User user);
    // Other methods  as needed
}