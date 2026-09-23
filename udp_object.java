import UDP.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udp_object {
    public static void main(String[] args) throws Exception {
        DatagramSocket sk = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("36.50.135.242");
        byte[] rq = ";B23DCCN863;h1arVBat".getBytes();
        sk.send(new DatagramPacket(rq, rq.length, ip, 2209));
        byte[] bf1 = new byte[4096];
        sk.receive(new DatagramPacket(bf1, bf1.length));
        String inp = new String(bf1, 0, 8);
        ObjectInputStream oi = new ObjectInputStream(new ByteArrayInputStream(bf1, 8, bf1.length));
        Student st = (Student) oi.readObject();
        String[] tmp = st.name.split(" ");

        String rname = "";
        String mail = "";
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = tmp[i].substring(0, 1).toUpperCase() + tmp[i].substring(1).toLowerCase();
            rname += tmp[i] + " ";
            if (i == tmp.length - 1) {
                mail = tmp[i].toLowerCase()+mail;
            } else
                mail += tmp[i].toLowerCase().charAt(0);
        }
        st.name = rname.trim();
        st.email = mail + "@ptit.edu.vn";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(inp.getBytes());
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(st);
        os.flush();
        System.out.println(st.id);
        System.out.println(st.code);
        System.out.println(st.name);
        System.out.println(st.email);
        byte[] out2 = bos.toByteArray();
        sk.send(new DatagramPacket(out2, out2.length, ip, 2209));
        sk.close();
    }
}