package backend.businesslayer;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> findEmployeeByProjectId(int projectId) throws SQLException;

    List<User> findManagerProject() throws SQLException;

    User login(String email, String password) throws SQLException;

}
