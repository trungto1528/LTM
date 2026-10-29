
import TCP.Customer;

import java.net.*;
import java.io.*;

public class TCP_4bgKgFyG {
    public static void main(String[] args) throws Exception {
        Socket sk = new Socket("36.50.135.242", 2209);
        ObjectInputStream is = new ObjectInputStream(sk.getInputStream());
        ObjectOutputStream os = new ObjectOutputStream(sk.getOutputStream());
        os.writeObject("B23DCCN863;4bgKgFyG");
        os.flush();
        Customer cm = (Customer) is.readObject();

        String[] a = cm.getName().split(" ");
        StringBuilder usn=new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i].substring(0, 1).toUpperCase() + a[i].substring(1).toLowerCase();
        }
        a[a.length - 1] = a[a.length - 1].toUpperCase();
        StringBuilder st = new StringBuilder(a[a.length - 1]);
        st.append(", ");
        for (int i = 0; i < a.length - 1; i++) {
            usn.append(a[i].substring(0,1).toLowerCase());
            st.append(a[i] + " ");
        }
        usn.append(a[a.length-1].toLowerCase());
        String[] dob=cm.getDayOfBirth().split("-");
        cm.setDayOfBirth(dob[1]+"/"+dob[0]+"/"+dob[2]);
        cm.setName(st.toString());
        cm.SetUsername(usn.toString());
        System.out.println(cm.getId() + "\n" + cm.getCode() + "\n" + cm.getName() +
                "\n" + cm.getDayOfBirth() + "\n"
                + cm.getUsername());
        os.writeObject(cm);
        sk.close();
    }
}



















































