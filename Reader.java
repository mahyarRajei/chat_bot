import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * read Text file
 */
class Reader {

    static String read(String fileName) {

        StringBuilder temp = null;

        File file = new File(fileName);
        if (file.exists()) {
            try {
                FileInputStream fIn = new FileInputStream(fileName);
                temp = new StringBuilder();
                int c;
                while ((c = fIn.read()) != -1) {
                    temp.append((char) c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return String.valueOf(temp);
    }
}
