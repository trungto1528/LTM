
import java.util.*;

import TCP.Laptop;

import java.net.*;
import java.io.*;

public class qxk6Zpyr {
    public static void main(String[] args) throws Exception {
        Socket sk = new Socket("36.50.135.242", 2209);
        ObjectInputStream is = new ObjectInputStream(sk.getInputStream());
        ObjectOutputStream os = new ObjectOutputStream(sk.getOutputStream());
        os.writeObject("B23DCCN863;qxk6Zpyr");
        os.flush();
        Laptop lt = (Laptop) is.readObject();
        System.out.println(lt.getId() + "\n" + lt.getCode() + "\n" + lt.getName() + "\n" + lt.getQuantity());
        String[] a = lt.getName().split(" ");
        String b = a[0];
        a[0] = a[a.length - 1];
        a[a.length - 1] = b;
        StringBuilder st = new StringBuilder();
        for (String string : a) {
            st.append(string + " ");
        }
        ;
        lt.setName(st.toString().trim());
        System.out.println(lt.getId() + "\n" + lt.getCode() + "\n" + lt.getName() + "\n" + lt.getQuantity());
        StringBuilder qt = new StringBuilder(String.valueOf(lt.getQuantity()));
        qt.reverse();
        lt.setQuantity(Integer.parseInt(qt.toString()));
        os.writeObject(lt);
        sk.close();
    }
}