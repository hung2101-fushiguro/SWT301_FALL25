package lab4_part2;

import java.io.*;
import java.util.logging.Logger;

class PathTraversalExample {
    private static final Logger logger = Logger.getLogger(PathTraversalExample.class.getName());
    private static final String BASE_DIR = "/safe_directory"; // thư mục an toàn

    public static void main(String[] args) throws IOException {
        String userInput = "../secret.txt";
        File file = new File(BASE_DIR, userInput);
        String canonicalBase = new File(BASE_DIR).getCanonicalPath();
        String canonicalPath = file.getCanonicalPath();

        if (!canonicalPath.startsWith(canonicalBase)) {
            logger.warning("Access denied: invalid path traversal attempt!");
            return;
        }

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                logger.info("Reading file: " + file.getPath());
            }
        } else {
            logger.warning("File not found: " + file.getPath());
        }
    }
}
