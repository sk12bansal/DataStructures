import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class StringSize {

    public static List<String> cutString(String original, int chunkSize, String encoding) throws UnsupportedEncodingException {
        List<String> strings = new ArrayList<>();
        final int end = original.length();
        int from = 0, to = 0;
        do {
            to = (to + chunkSize > end) ? end : to + chunkSize; // next chunk, watch out for small strings
            String chunk = original.substring(from, to); // get chunk
            System.out.println(" " + to);
            while (chunk.getBytes(encoding).length > chunkSize) { // adjust chunk to proper byte size if necessary
                chunk = original.substring(from, --to);
            }
            strings.add(chunk); // add chunk to collection
            from = to; // next chunk
        } while (to < end);
        return strings;
    }

    public  static void main(String [] args) throws UnsupportedEncodingException {
        String string = "0123456789ABCDEF";
        StringBuilder bigAssString = new StringBuilder(1024*1024*3);
        for (int i = 0; i < ((1024*1024*3)/16); i++) {
            bigAssString.append(string);
        }
        System.out.println("bigAssString.length = " + bigAssString.toString().length());
        bigAssString.replace((1024*1024*3)/4, ((1024*1024*3)/4)+1, "á");

        for (String chunk : cutString(bigAssString.toString(), 1024*1024, "UTF-8")) {
            try {
                System.out.println(String.format(
                        "Chunk [...] - Chars: %d - Bytes: %d",
                        chunk.length(), chunk.getBytes("UTF-8").length));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
