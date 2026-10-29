import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
public class t44L4Hu9J {
    public static void send(SocketChannel sc, String pl) throws Exception{
        byte[] bt=pl.getBytes();
        ByteBuffer bf= ByteBuffer.allocate(4+bt.length);
        bf.putInt(bt.length);
        bf.put(bt);
        bf.flip();
        while (bf.hasRemaining())sc.write(bf);
    }
    public static byte[] read(SocketChannel sc) throws Exception{
        ByteBuffer bf1=ByteBuffer.allocate(4);
        while (bf1.hasRemaining()){
            sc.read(bf1);
        }
        bf1.flip();
        int length=bf1.getInt();
        ByteBuffer bf2= ByteBuffer.allocate(length);
        while (bf2.hasRemaining()){
            sc.read(bf2);
        }
        return bf2.array();
    }
    public static void main(String[] args) throws Exception{
        SocketChannel sc= SocketChannel.open();
        sc.connect(new InetSocketAddress("36.50.135.242", 2211));
        sc.configureBlocking(true);
        send(sc,"B23DCCN863;44L4Hu9J");
        ByteArrayOutputStream baos= new ByteArrayOutputStream();
        for(int i=0;i<3;i++){
            byte[] pl=read(sc);
            baos.write(pl);
        }
        String inp=baos.toString();
        System.out.println(inp);
        String[] a=inp.split("\r\n");
        String x=a[0].split(" ")[0];
        String y=a[0].split(" ")[1];
        String z=a[1].substring(5).trim();
        send(sc,x+";"+y+";"+z);
        sc.close();
    }
}
