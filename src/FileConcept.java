import java.io.File;
import java.io.IOException;

public class FileConcept {
    public static void main(final String[] args) {
        final File f = new File("/Users/surakum2/Documents/Java Programs/src/file.txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}