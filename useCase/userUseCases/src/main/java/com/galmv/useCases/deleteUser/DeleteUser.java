package com.galmv.useCases.deleteUser;

import java.util.UUID;

public interface DeleteUser {
    void executeWith(UUID userId);
}
