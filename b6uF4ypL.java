import java.util.*;
import java.net.*;
import java.io.*;
public class b6uF4ypL {
    public static void main(String[] args) throws Exception{
        DatagramSocket sk= new DatagramSocket();
        InetAddress ip= InetAddress.getByName("36.50.135.242");
        sk.send(new DatagramPacket(";B23DCCN863;b6uF4ypL".getBytes(),":B23DCCN863;b6uF4ypL".getBytes().length, ip,2207));
        byte[] bf=new byte[1024];
        DatagramPacket dpk=new DatagramPacket(bf, bf.length);
        sk.receive(dpk);
        String inp=new String(bf);
        System.out.println(inp);
        sk.close();
    }
}
//Bài này troll VN thôi đừng xem
