package hungth.example;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class AccountService {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+=\\-]).{7,}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    private static final Set<String> registeredUsernames = new HashSet<>();
    private static final Set<String> registeredEmail = new HashSet<>();

    public boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean registerAccount(String username, String password, String email) {
        // 1. Username, password, email là bắt buộc
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            return false;
        }

        // 2. Username phải > 3 ký tự
        if (username.length() <= 3) {
            return false;
        }

        // 3. Kiểm tra trùng username
        if (registeredUsernames.contains(username)) {
            return false;
        }

        // 4. Password phải hợp lệ
        if (!isValidPassword(password)) {
            return false;
        }

        // 5. Email hợp lệ
        if (!isValidEmail(email)) {
            return false;
        }
        //6.Trung email
        if(registeredEmail.contains(email)){
            return false;
        }

        // Nếu qua hết các bước → đăng ký thành công
        registeredUsernames.add(username);
        registeredEmail.add(email);
        return true;
    }

    // Reset danh sách user giữa các test
    public static void clearRegisteredUsers() {
        registeredUsernames.clear();
        registeredEmail.clear();
    }
}
