package com.galmv.user.useCases.deleteUser;

import java.util.UUID;

public interface DeleteUser {
    void executeWith(UUID userId);
}
