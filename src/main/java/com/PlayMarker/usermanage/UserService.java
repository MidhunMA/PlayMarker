package com.PlayMarker.usermanage;




public interface UserService {
    User registerUser(User user);
    boolean loginUser(String email, String password);
    String updateUser(Long id, User user);
    User findUsername(String email);
    String deleteUser(Long id);
    UserDO getUser(Long id);
    // Other methods  as needed
}