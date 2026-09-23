import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Collections;

public class ULhzPLLDbruh {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242", 2206);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        String code = "B23DCCN863;ULhzPLLD";
        outputStream.write(code.getBytes());
        outputStream.flush();

        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String inp = new String(buffer, 0, bytesRead);
        int[] a = Arrays.stream(inp.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] b = a.clone();
        Arrays.sort(b);
        int n = -1;
        for(int i=0;i<a.length;i++){
            if(a[i]==b[a.length-2]){
                n=i;
                break;
            }
        }
        String out = a[n]+","+n;
        outputStream.write(out.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
