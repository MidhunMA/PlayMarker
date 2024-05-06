package com.PlayMarker.usermanage;




public interface UserService {
    void registerUser(User user);
    boolean loginUser(String email, String password);
    String updateUser(Long id, User user);
    User findUsername(String email);
    void deleteUser(String username);
    UserDO getUser(Long id);
    // Other methods  as needed
}