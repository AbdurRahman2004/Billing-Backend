package com.abdur.BillingSoftware.service;

import com.abdur.BillingSoftware.io.UserRequest;
import com.abdur.BillingSoftware.io.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
}
