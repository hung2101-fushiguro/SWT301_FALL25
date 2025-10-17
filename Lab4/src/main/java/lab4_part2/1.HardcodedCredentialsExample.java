package lab4_part2;

import java.util.logging.Logger;

class HardcodedCredentialsExample {
    private static final Logger logger = Logger.getLogger(HardcodedCredentialsExample.class.getName());

    public static void main(String[] args) {
        // Lấy username và password từ biến môi trường (hoặc có thể dùng file config)
        String username = System.getenv("APP_USERNAME");
        String password = System.getenv("APP_PASSWORD");

        if (username == null || password == null) {
            logger.warning("Chưa thiết lập thông tin đăng nhập trong biến môi trường!");
            return;
        }

        if (authenticate(username, password)) {
            logger.info("Access granted");
        } else {
            logger.warning("Access denied");
        }
    }

    private static boolean authenticate(String user, String pass) {
        String storedUser = System.getenv("APP_USERNAME");
        String storedPass = System.getenv("APP_PASSWORD");
        return user.equals(storedUser) && pass.equals(storedPass);
    }
}
