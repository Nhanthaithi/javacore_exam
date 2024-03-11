package frontend;

import backend.presentationlayer.UserController;
import entity.User;
import lombok.AllArgsConstructor;
import utils.JdbcUtil;
import utils.ScannerUtil;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class UserFunction {
    private UserController userController;


    public void showMenu() throws SQLException {

        while (true) {
            System.out.println("1. Đăng nhập");
            System.out.println("2. Hiển thị danh sách Employee user theo Project");
            System.out.println("3. Hiển thị danh sách Manager user của tất cả Project");
            System.out.println("4. Thoát chương trình");
            System.out.println("Mời bạn chọn menu: ");

            int menu = ScannerUtil.inputInt();
            switch (menu) {
                case 1:
                    login();
                    break;
                case 2:
                    findEmployeeByProjectId();
                    break;
                case 3:
                    findManagerProject();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Mời bạn chọn lại đúng chức năng menu");
            }

        }
    }


    private void findEmployeeByProjectId() throws SQLException {
        System.out.println("Vui lòng nhập project Id cần tìm");
        int projectId = ScannerUtil.inputInt();
        List<User> users = userController.findEmployeeByProjectId(projectId);
        System.out.println("Danh sách Employee user");
        System.out.println("+--------+--------------------+--------------------+--------------------+--------------------+");
        System.out.println("|   ID   |       EMAIL        |      FULL NAME     |         ROLE       |      PRO SKILLS    |");
        System.out.println("+--------+--------------------+--------------------+--------------------+--------------------+");
        if (users.isEmpty()) {
            System.out.printf("| %-6s | %-18s | %-18s | %-18s | %-18s |%n", "NULL", "NULL", "NULL", "NULL", "NULL");
            System.out.println("+--------+--------------------+--------------------+--------------------+--------------------+");
        } else {
            for (User user : users) {
                int id = user.getId();
                String email = user.getEmail();
                String fullname = user.getFullname();
                User.Role role = user.getRole();
                String skill = user.getProSkill();
                System.out.printf("| %-6s | %-18s | %-18s | %-18s | %-18s |%n", id, email, fullname, role, skill);
                System.out.println("+--------+--------------------+--------------------+--------------------+--------------------+");
            }
        }
    }

    private void findManagerProject() throws SQLException {
        List<User> users = userController.findManagerProject();
        System.out.println("Danh sách Manager User");
        System.out.println("+--------+--------------------+--------------------+--------------------+--------------------+--------------------+");
        System.out.println("|   ID   |       EMAIL        |      FULL NAME     |         ROLE       |   EXPERIENCE YEAR  |      PROJECT ID    |");
        System.out.println("+--------+--------------------+--------------------+--------------------+--------------------+--------------------+");
        if (users.isEmpty()) {
            System.out.printf("| %-6s | %-18s | %-18s | %-18s | %-18s | %-18s |%n", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL");
            System.out.println("+--------+--------------------+--------------------+--------------------+--------------------+--------------------+");
        } else {
            for (User user : users) {
                int id = user.getId();
                String email = user.getEmail();
                String fullname = user.getFullname();
                User.Role role = user.getRole();
                int exInYear = user.getExperInYear();
                int projectId = user.getProjectId();
                System.out.printf("| %-6s | %-18s | %-18s | %-18s | %-18s | %-18s |%n", id, email, fullname, role, exInYear, projectId);
                System.out.println("+--------+--------------------+--------------------+--------------------+--------------------+--------------------+");
            }
        }
    }


    private void login() throws SQLException {
        System.out.println("Nhập thông tin Email User");
        String email = ScannerUtil.inputEmail();
        System.out.println("Nhập thông tin password User");
        String password = ScannerUtil.inputPassword();
        User user = userController.login(email, password);
        if (user == null) {
            System.out.println("Email or password is invalid");
        } else {
            System.out.println("Thông tin user tìm thấy");
            System.out.println("+--------+--------------------+--------------------+--------------------+");
            System.out.println("|   ID   |       EMAIL        |      FULL NAME     |         ROLE       |");
            System.out.println("+--------+--------------------+--------------------+--------------------+");
            int id = user.getId();
            String fullname = user.getFullname();
            User.Role role = user.getRole();
            System.out.printf("| %-6s | %-18s | %-18s | %-18s |%n", id, email, fullname, role);
            System.out.println("+--------+--------------------+--------------------+--------------------+");

        }
    }

}
