package ru.nsu.ccfit.khudyakov.mockito;

import java.time.ZonedDateTime;
import java.util.UUID;

public class UserService {

    private final UserRepository userRepository;
    private final UserAccessService userAccessService;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserAccessService userAccessService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userAccessService = userAccessService;
        this.userMapper = userMapper;
    }

    public UserDTO getById(UUID id) {
        UserEntity user = userRepository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Couldn't find user by id " + id)
            );

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        userAccessService.setAccessTime(user, zonedDateTime);

        return userMapper.map(user);
    }

}
