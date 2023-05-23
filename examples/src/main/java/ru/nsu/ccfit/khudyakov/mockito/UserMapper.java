package ru.nsu.ccfit.khudyakov.mockito;

public class UserMapper {

    public UserDTO map(UserEntity user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }

}
