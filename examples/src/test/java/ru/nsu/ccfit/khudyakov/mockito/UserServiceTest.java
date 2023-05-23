package ru.nsu.ccfit.khudyakov.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper;

    @Mock
    private UserAccessService userAccessService;

    @InjectMocks
    private UserService userService;

    @Captor
    private ArgumentCaptor<UserEntity> captor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getById() {
        UUID id = UUID.randomUUID();

        UserEntity user = new UserEntity();
        user.setId(id);
        user.setUsername("username");

        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));

        Mockito.doAnswer(a -> {
            UserEntity arg = a.getArgument(0);
            ZonedDateTime zonedDateTime = a.getArgument(1);
            arg.setLastAccessTime(zonedDateTime);
            return null;
        }).when(userAccessService).setAccessTime(user, ZonedDateTime.now());

        UserDTO userDTO = userService.getById(id);

        InOrder order = Mockito.inOrder(userRepository, userAccessService, userMapper);
        order.verify(userRepository).findById(id);
        order.verify(userAccessService).setAccessTime(eq(user), any());
        order.verify(userMapper).map(captor.capture());

        UserEntity value = captor.getValue();

        assertEquals(user.getUsername(), userDTO.getUsername());
    }

    @Test
    void getById_userDoesntExistInDatasource_throwException() {
        UUID id = UUID.randomUUID();

        Mockito.when(userRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.getById(id));
        assertEquals("Couldn't find user by id " + id, exception.getMessage());

        Mockito.verify(userRepository).findById(id);
    }

}