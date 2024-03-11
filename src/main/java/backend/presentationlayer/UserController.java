package backend.presentationlayer;

import entity.User;
import lombok.AllArgsConstructor;
import backend.businesslayer.IUserService;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class UserController {
    private IUserService userService;

    public List<User> findEmployeeByProjectId(int id) throws SQLException {
        return userService.findEmployeeByProjectId(id);
    }

    public List<User> findManagerProject() throws SQLException {
        return userService.findManagerProject();
    }

    public User login(String email, String password) throws SQLException {
        return userService.login(email, password);
    }

}
