package ru.nsu.ccfit.khudyakov.mockito;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<UserEntity> findById(UUID id);

}
