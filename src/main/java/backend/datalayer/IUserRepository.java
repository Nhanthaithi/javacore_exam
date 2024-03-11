package backend.datalayer;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    User login(String email, String password) throws SQLException;

    List<User> findEmployeeByProjectId(int projectId) throws SQLException;
    List<User> findManageryProject() throws SQLException;
}
