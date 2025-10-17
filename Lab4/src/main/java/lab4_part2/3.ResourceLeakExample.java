package lab4_part2;

import java.io.*;
import java.util.logging.Logger;

class ResourceLeakExample {
    private static final Logger logger = Logger.getLogger(ResourceLeakExample.class.getName());

    public static void main(String[] args) {
        // Dùng try-with-resources để tự động đóng reader
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info(line);
            }
        } catch (IOException e) {
            logger.severe("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
