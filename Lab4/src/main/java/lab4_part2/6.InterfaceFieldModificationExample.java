package lab4_part2;

class AppConfig {
    // Đây là một biến static, có thể truy cập toàn cục và thay đổi giá trị.
    public static int maxUsers = 100;
}

class MutableStaticFieldExample {
    public static void main(String[] args) {
        // Read the initial value
        System.out.println("Initial value of AppConfig.maxUsers: " + AppConfig.maxUsers);

        // Modify the value
        System.out.println("Changing the value to 200...");
        AppConfig.maxUsers = 200;

        // Read the value again to confirm it has been successfully changed
        System.out.println("New value of AppConfig.maxUsers: " + AppConfig.maxUsers);
    }
}
