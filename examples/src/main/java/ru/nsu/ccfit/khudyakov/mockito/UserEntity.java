package ru.nsu.ccfit.khudyakov.mockito;

import java.time.ZonedDateTime;
import java.util.UUID;

public class UserEntity {

    private UUID id;

    private String username;

    private String password;

    private ZonedDateTime lastAccessTime;

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

    public ZonedDateTime getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(ZonedDateTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }
}
