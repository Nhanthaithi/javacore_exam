package frontend;


import backend.businesslayer.IUserService;
import backend.businesslayer.UserService;
import backend.datalayer.IUserRepository;
import backend.datalayer.UserRepository;
import backend.presentationlayer.UserController;

import java.sql.SQLException;


public class UserProgram {
    public static void main(String[] args) throws SQLException {
        IUserRepository userRepository = new UserRepository();
        IUserService userService = new UserService(userRepository);
        UserController userController = new UserController(userService);
        UserFunction userFunction = new UserFunction(userController);
        userFunction.showMenu();
    }
}
