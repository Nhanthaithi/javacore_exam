package backend.datalayer;

import entity.User;
import utils.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserRepository implements IUserRepository {

    @Override
    public List<User> findEmployeeByProjectId(int projectId) throws SQLException {
        String sql = "SELECT * FROM users WHERE project_id = ? AND role = ?";
        try (Connection connection = JdbcUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            List<User> users = new ArrayList<>();
            pstmt.setInt(1, projectId);
            pstmt.setString(2, User.Role.EMPLOYEE.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                int id = rs.getInt("id");
                user.setId(id);
                String fullname = rs.getString("full_name");
                user.setFullname(fullname);
                String email = rs.getString("email");
                user.setEmail(email);
                String password = rs.getString("password");
                user.setPassword(password);
                String role = rs.getString("role");
                user.setRole(role);
                user.setProjectId(projectId);
                String skill = rs.getString("pro_skill");
                user.setProSkill(skill);
                users.add(user);
            }
            return users;
        }

    }

    @Override
    public List<User> findManageryProject() throws SQLException {
        String sql = "SELECT * FROM users WHERE role = ?";
        try (Connection connection = JdbcUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            List<User> users = new ArrayList<>();
            pstmt.setString(1, User.Role.MANAGER.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                int id = rs.getInt("id");
                user.setId(id);
                String fullname = rs.getString("full_name");
                user.setFullname(fullname);
                String email = rs.getString("email");
                user.setEmail(email);
                String password = rs.getString("password");
                user.setPassword(password);
                String role = rs.getString("role");
                user.setRole(role);
                int projectId = rs.getInt("project_id");
                user.setProjectId(projectId);
                int exInYear = rs.getInt("exp_in_year");
                user.setExperInYear(exInYear);
                users.add(user);
            }
            return users;
        }
    }

    @Override
    public User login(String email, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            User user = null;

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    user = new User();
                    int id = rs.getInt("id");
                    user.setId(id);
                    String fullname = rs.getString("full_name");
                    user.setFullname(fullname);
                    user.setEmail(email);
                    user.setPassword(password);
                    String role = rs.getString("role");
                    user.setRole(role);
                }
            }

            return user;
        }
    }


}
