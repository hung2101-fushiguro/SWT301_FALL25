package lab4_part2;

class NullPointerFixedExample {
    public static void main(String[] args) {
        String text = null;

        // Luôn kiểm tra null trước
        // Java sử dụng "short-circuit evaluation", nếu vế đầu (text != null) là false,
        // nó sẽ không kiểm tra vế sau (text.length() > 0), do đó tránh được lỗi.
        if (text != null && text.length() > 0) {
            System.out.println("Text is not empty");
        } else {
            System.out.println("Text is null or empty");
        }
    }
}