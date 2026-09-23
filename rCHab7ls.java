import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class rCHab7ls {
    public static void main(String[] args) {
        try {
            // 1. Kết nối tới server PTIT (Cài đặt timeout tối đa 5 giây theo đề bài)
            Socket sk = new Socket("36.50.135.242", 2210);
            sk.setSoTimeout(5000);
            
            OutputStream os = sk.getOutputStream();
            InputStream is = sk.getInputStream();

            // a. Gửi mã sinh viên và mã câu hỏi (Phải có dấu xuống dòng \n và nén GZIP)
            String qcode = "B23DCCN863;rCHab7ls\n"; 
            byte[] compressedQcode = compressGZIP(qcode.getBytes(StandardCharsets.UTF_8));
            os.write(compressedQcode);
            os.flush(); 

            // b. Nhận dữ liệu từ server và giải nén trực tiếp từ luồng Socket
            // Sử dụng cơ chế bọc luồng tiêu chuẩn. Để tránh GZIPInputStream đọc thừa dữ liệu, 
            // chúng ta đọc dữ liệu dòng text bằng BufferedReader.
            GZIPInputStream gis = new GZIPInputStream(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8));
            
            // Đọc dòng văn bản gốc do server gửi tới
            String inp = br.readLine();
            System.out.println("Nhan tu server: " + inp);

            // c. Thực hiện xử lý chuỗi (Đảo ngược và Mã hóa Base64)
            if (inp != null && !inp.isEmpty()) {
                StringBuilder sb = new StringBuilder(inp);
                String rv = sb.reverse().toString();
                String encode = Base64.getEncoder().encodeToString(rv.getBytes(StandardCharsets.UTF_8));
                
                // Cấu trúc định dạng gửi lên: <reversed_string>|<base64_string>\n
                String out ="\n";
                System.out.println("Gui di: " + out);

                // Nén GZIP kết quả lần 2
                byte[] compressedOut = compressGZIP(out.getBytes(StandardCharsets.UTF_8));
                os.write(out.getBytes());
                os.flush();
            }

            // d. Đóng kết nối an toàn và kết thúc chương trình
            br.close();
            gis.close();
            os.close();
            is.close();
            sk.close();
            System.out.println("Kết thúc chương trình thành công.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm tiện ích giúp nén mảng bytes thành định dạng GZIP độc lập trọn vẹn
    private static byte[] compressGZIP(byte[] data) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (GZIPOutputStream gos = new GZIPOutputStream(baos)) {
            gos.write(data);
            gos.finish(); // Bắt buộc finish để ghi Footer GZIP vào ByteArrayOutputStream
        } 
        return baos.toByteArray();
    }
}
