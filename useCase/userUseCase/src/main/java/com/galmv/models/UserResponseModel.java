package com.galmv.models;

import java.util.UUID;

public record UserResponseModel(UUID id, String name, String email, String password, String phone, String status, String photo) {}
