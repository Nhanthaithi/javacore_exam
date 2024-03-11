package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class JdbcUtil {
    public static Connection getConnection() throws SQLException {

        Properties properties = new Properties();
        try (InputStream inputStream = JdbcUtil.class.getResourceAsStream("/database.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Lỗi kết nối database " + e.getMessage());
            return null;
        }

        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, user, password);
    }

    public static void checkConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Connect successfully: " + Objects.requireNonNull(getConnection()).getCatalog());

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
