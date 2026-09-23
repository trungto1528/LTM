import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
public class OxKHwplz {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("36.50.135.242",2206);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        String code="B23DCCN863;OxKHwplz";
        outputStream.write(code.getBytes());
        outputStream.flush();

        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String inp= new String(buffer, 0, bytesRead);   
        ArrayList<Integer> n=new ArrayList<>();
        String[] arr=inp.trim().split(",");
        for(String s:arr){
            n.add(Integer.parseInt(s.trim()));
        };
        Collections.sort(n);
        int dif=Integer.MAX_VALUE;
        int a1=Integer.MAX_VALUE;
        int a2=Integer.MAX_VALUE;
        for (int i=1;i<n.size();i++){
            if(n.get(i)-n.get(i-1)<dif){
                dif=n.get(i)-n.get(i-1);
                a1=n.get(i-1);
                a2=n.get(i);
            }
        };
        outputStream.write((dif+","+a1+","+a2).getBytes());
        outputStream.close();
    }
}
