import java.util.*;
import java.net.*;
import java.io.*;
public class kWo5F4dg {
    public static void main(String[] args) throws Exception {
        Socket sk= new Socket("36.50.135.242", 2207);
        DataInputStream is= new DataInputStream(sk.getInputStream());
        DataOutputStream os = new DataOutputStream(sk.getOutputStream());
        os.writeUTF("B23DCCN863;kWo5F4dg");
        os.flush();
        int a= is.readInt();
        System.out.println(a);
        int b= is.readInt();
        System.out.println(b);
        os.writeInt(a+b);
        os.writeInt(a*b);
        os.close();
    }
}
