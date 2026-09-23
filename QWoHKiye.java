import java.util.*;
import java.net.*;
import java.io.*;

public class QWoHKiye {
    public static void main(String[] args) throws Exception {
        Socket sk = new Socket("36.50.135.242", 2208);
        BufferedReader is = new BufferedReader(new InputStreamReader(sk.getInputStream()));
        BufferedWriter os = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));
        String code = "B23DCCN863;QWoHKiye";
        os.write(code);
        os.newLine();
        os.flush();
        String inp = is.readLine();
        System.out.println(inp);
        Map<Character, Integer> a = new LinkedHashMap<>();
        for (Character i : inp.toCharArray()) {
            if (Character.isLetterOrDigit(i)) {
                a.put(i, a.getOrDefault(i, 0) + 1);
            }
        }
        StringBuilder out = new StringBuilder();
        a.forEach((k, v) -> {
            if (v > 1)
                out.append(k + ":" + v + ",");
        });
        System.out.println(out);
        os.write(out.toString());
        os.close();
    }
}