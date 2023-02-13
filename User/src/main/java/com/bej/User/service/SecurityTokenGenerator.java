package com.bej.User.service;

import com.bej.User.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String, String> generateToken(User user);
}
