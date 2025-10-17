package lab4_part2;
class CatchSpecificExceptionExamples {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            // Dòng này sẽ gây ra ArrayIndexOutOfBoundsException
            System.out.println(arr[10]);
        }
        // Bắt chính xác lỗi truy cập ngoài giới hạn của mảng
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Array index is out of bounds.");
            // In ra stack trace sẽ cho thấy chính xác lỗi và vị trí xảy ra
            // e.printStackTrace();
        }
    }
}