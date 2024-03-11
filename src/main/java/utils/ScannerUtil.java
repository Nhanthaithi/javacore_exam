package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerUtil {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputString() {
        return SCANNER.nextLine().trim().replaceAll("\\s{2,}", " ");
    }

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(inputString());
            } catch (NumberFormatException e) {
                System.err.println("Nhập vào số nguyên");
            }
        }
    }

    public static String inputEmail() {
        String emailRegex = "^[\\w-_.+]+@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{2,})$";

        while (true) {
            System.out.println("Please enter your email with right format:");
            String email = inputString(); // Đọc và lưu email nhập vào

            if (Pattern.matches(emailRegex, email)) {
                return email; // Nếu hợp lệ, trả về email và thoát khỏi vòng lặp
            } else {
                System.out.println("Email is not valid. Please try again.");
            }
        }
    }


    public static String inputPassword() {
        String passwordRegex = "^.{6,12}$";

        while (true) {
            System.out.println("Please enter your password (6 to 12 characters long):");
            String password = inputString(); // Đọc và lưu mật khẩu nhập vào

            if (Pattern.matches(passwordRegex, password)) {
                return password; // Nếu hợp lệ, trả về mật khẩu và thoát khỏi vòng lặp
            } else {
                System.out.println("Password is not valid. Please try again.");
            }
        }
    }

}
