package backend.businesslayer;

import backend.datalayer.IUserRepository;
import entity.User;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Override
    public List<User> findEmployeeByProjectId(int projectId) throws SQLException {
        return userRepository.findEmployeeByProjectId(projectId);
    }

    @Override
    public List<User> findManagerProject() throws SQLException {
        return userRepository.findManageryProject();
    }

    @Override
    public User login(String email, String password) throws SQLException {
        return userRepository.login(email, password);
    }


}
