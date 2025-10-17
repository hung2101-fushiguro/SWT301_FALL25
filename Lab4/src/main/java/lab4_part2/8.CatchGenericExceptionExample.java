package lab4_part2;

class CatchSpecificExceptionExample {
    public static void main(String[] args) {
        try {
            String s = null;
            System.out.println(s.length());
        }
        // Bắt chính xác NullPointerException
        catch (NullPointerException e) {
            System.err.println("Error: Attempted to use a null reference.");
            // In ra stack trace để gỡ lỗi dễ hơn (thực tế hay dùng logger)
            // e.printStackTrace();
        }
    }
}