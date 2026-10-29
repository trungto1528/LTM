import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class rCHab7ls {
    public static void main(String[] args) throws Exception {
        // 1. Kết nối tới server PTIT (Cài đặt timeout tối đa 5 giây theo đề bài)
        Socket sk = new Socket("36.50.135.242", 2210);

        OutputStream os = sk.getOutputStream();
        InputStream is = sk.getInputStream();

        // a. Gửi mã sinh viên và mã câu hỏi (Phải có dấu xuống dòng \n và nén GZIP)
        String qcode = "B23DCCN863;rCHab7ls\n";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        GZIPOutputStream gos = new GZIPOutputStream(baos);
        gos.write(qcode.getBytes(StandardCharsets.UTF_8));
        gos.finish();
        os.write(baos.toByteArray());
        os.flush();

        GZIPInputStream gip = new GZIPInputStream(is);
        ByteArrayOutputStream bo= new ByteArrayOutputStream();
        int b;
        while((( b = gip.read()) != -1 )&& (b != '\n')){
            bo.write(b);
        }
        String inp=new String(bo.toByteArray());
        StringBuilder sb = new StringBuilder(inp);
        String rv = sb.reverse().toString();
        String encode = Base64.getEncoder().encodeToString(rv.getBytes(StandardCharsets.UTF_8));

        System.out.println(inp);
        String out = rv + "|" + encode + "\n";
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        GZIPOutputStream gos2 = new GZIPOutputStream(baos2);
        gos2.write(out.getBytes(StandardCharsets.UTF_8));
        gos2.finish();
        os.write(baos2.toByteArray());
        os.flush();
    }
}
