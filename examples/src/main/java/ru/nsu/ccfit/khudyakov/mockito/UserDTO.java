package ru.nsu.ccfit.khudyakov.mockito;

import java.util.UUID;

public class UserDTO {

    private UUID id;

    private String username;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
