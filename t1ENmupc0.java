import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class t1ENmupc0 {
    public static void main(String[] args) throws Exception {
        Socket sk = new Socket("36.50.135.242", 2210);
        OutputStream os = sk.getOutputStream();
        InputStream is = sk.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gos = new GZIPOutputStream(baos);
        gos.write("B23DCCN863;1ENmupc0\n".getBytes());
        gos.finish();
        os.write(baos.toByteArray());
        os.flush();
        ByteArrayOutputStream re = new ByteArrayOutputStream();
        GZIPInputStream gis = new GZIPInputStream(is);
        int b;
        while ((b = gis.read()) != -1 && b != '\n') {
            re.write(b);
        }
        String inp = re.toString();
        System.out.println(inp);
        char[] a = inp.toCharArray();
        Arrays.sort(a);
        String out = "";
        for (char c : a) {
            out += c;
        }

        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        GZIPOutputStream gos2 = new GZIPOutputStream(baos2);
        gos2.write(out.getBytes());
        gos2.finish();
        os.write(baos2.toByteArray());
        os.flush();
        sk.close();
    }
}
