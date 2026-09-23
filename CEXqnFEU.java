import java.io.*;
import java.net.*;

public class CEXqnFEU {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("36.50.135.242", 2208);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        String studentCode = "B23DCCN863";
        String qCode = "CEXqnFEU";

        bw.write(studentCode + ";" + qCode);
        bw.newLine();
        bw.flush();
        String inp = br.readLine();
        String[] arr = inp.trim().split(",");

        StringBuilder outp = new StringBuilder();

        for (String domain : arr) {
            domain = domain.trim();

            if (domain.endsWith(".edu")) {
                if (outp.length() > 0) {
                    outp.append(", ");
                }
                outp.append(domain);
            }
        }
        bw.write(outp.toString());
        bw.newLine();
        bw.flush();
        socket.close();
    }
}