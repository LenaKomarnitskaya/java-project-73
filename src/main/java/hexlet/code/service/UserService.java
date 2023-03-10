package hexlet.code.service;

import hexlet.code.dto.UserDto;
import hexlet.code.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User getUserById(long id);
    User createNewUser(UserDto userDto);

    User updateUser(long id, UserDto userDto);

    User getCurrentUser();
    String getCurrentUserName();
    void deleteUser(long id);
}
