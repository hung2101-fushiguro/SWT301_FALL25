package hungth.example;

import java.util.regex.Pattern;

public class AccountService {
    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final int MIN_PASSWORD_LENGTH = 6;

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean registerAccount(String username, String password, String email) {
        // Xử lý trường hợp username là null hoặc rỗng
        if (username == null || username.trim().isEmpty()) {
            return false;
        }

        // Mật khẩu phải lớn hơn 6 ký tự
        if (password == null || password.length() <= MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (!isValidEmail(email)) {
            return false;
        }
        return true;
    }
}

