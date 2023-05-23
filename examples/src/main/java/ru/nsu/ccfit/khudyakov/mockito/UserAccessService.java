package ru.nsu.ccfit.khudyakov.mockito;

import java.time.ZonedDateTime;

public interface UserAccessService {

    void setAccessTime(UserEntity user, ZonedDateTime zonedDateTime);

}
