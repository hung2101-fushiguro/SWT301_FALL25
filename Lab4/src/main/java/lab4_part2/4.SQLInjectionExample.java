package lab4_part2;

import java.sql.*;
import java.util.logging.Logger;

class SQLInjectionExample {
    private static final Logger logger = Logger.getLogger(SQLInjectionExample.class.getName());

    public static void main(String[] args) {
        // Giả sử lấy input từ user (cmd args, UI, ...). Đây chỉ là ví dụ test.
        String userInput = "' OR '1'='1";

        String sql = "SELECT * FROM users WHERE username = ?";

        // Thực tế: lấy connection từ connection pool, user DB với quyền tối thiểu
        try (Connection conn = DriverManager.getConnection("jdbc:yourdb://host:port/dbname", "dbuser", "dbpass");
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Bind parameter -> neutralize SQL injection
            ps.setString(1, userInput);

            logger.info("Executing parameterized query (username param bound).");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // xử lý kết quả (ví dụ: in username)
                    logger.info("Found user: " + rs.getString("username"));
                }
            }

        } catch (SQLException e) {
            logger.severe("DB error: " + e.getMessage());
        }
    }
}
