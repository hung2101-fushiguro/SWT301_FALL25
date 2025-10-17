package lab4_part2;

interface LoginHandler {


    boolean login(String username, String password);
}

// Một lớp ví dụ triển khai interface này
class SimpleLoginHandler implements LoginHandler {
    @Override
    public boolean login(String username, String password) {
        // Đây là nơi chứa logic xác thực thực tế
        if ("admin".equals(username) && "password123".equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed!");
            return false;
        }
    }
}
