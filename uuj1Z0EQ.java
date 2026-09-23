import java.util.*;
import java.net.*;
import java.io.*;
public class uuj1Z0EQ {
    public static void main(String[] args) throws Exception{
        Socket sk=new Socket("36.50.135.242", 2207);
        DataInputStream is = new DataInputStream(sk.getInputStream());
        DataOutputStream os =new DataOutputStream(sk.getOutputStream());
        os.writeUTF("B23DCCN863;uuj1Z0EQ");
        os.flush();
        String inp=is.readUTF();
        int n= is.readInt();
        StringBuilder out=new StringBuilder();
        for(Character i:inp.toCharArray()){
            if(Character.isLetter(i))
            if(Character.isLetter((char)(i-n))){
                out.append((char)(i-n));
            } else {
                out.append((char)(i-n+26));
            } else out.append(i);
        };
        os.writeUTF(out.toString());
        os.close();
    }
}
