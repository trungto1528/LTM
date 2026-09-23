import java.net.*;
import java.util.*;
public class UDP_8NampzyO {
    public static void main(String[] args) throws Exception{
        DatagramSocket sk=new DatagramSocket();
        InetAddress ip= InetAddress.getByName("36.50.135.242");
        byte[] bf=new byte[1024];
        sk.send(new DatagramPacket(";B23DCCN863;8NampzyO".getBytes(), ";B23DCCN863;b6uF4ypL".getBytes().length,ip,2207));
        DatagramPacket dpk=new DatagramPacket(bf, bf.length);
        sk.receive(dpk);
        String inp=new String(bf).trim();   
        System.out.println(inp);
        String rqid= inp.split(";")[0];
        String rinp=inp.split(";")[1];
        String[] a = rinp.split(",");
        int[] b=new int[a.length];
        for(int i=0;i<a.length;i++)b[i]=Integer.parseInt(a[i]);
        Arrays.sort(b);
        String out=rqid+";"+b[a.length-1]+","+b[0];
        sk.send(new DatagramPacket(out.getBytes(),out.getBytes().length,ip,2207));
        sk.close();
    }
}
