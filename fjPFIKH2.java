
import RMI.DataService;
import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.DecimalFormat;
import java.util.Arrays;

public class fjPFIKH2 {
    public static void main(String[] args) throws Exception{
        Registry reg= LocateRegistry.getRegistry("36.50.135.242");
        DataService ds= (DataService)reg.lookup("RMIDataService");
        String sc= "B23DCCN863";
        String qc="fjPFIKH2";
        String raw= (String)ds.requestData(sc, qc);
        System.out.println(raw);
        String inp[]= raw.split(",");
        double[] num= new double[inp.length];
        double average=0;
        for (int inp2 = 0; inp2 < inp.length; inp2++) {
            num[inp2]=Double.parseDouble(inp[inp2]);
            System.out.println(num[inp2]);
            average+=num[inp2];
        };
        Arrays.sort(num);
        average/=inp.length;
        System.out.println(average);
        double stddev=0;
        for(double d:num){
            stddev+=(d-average)*(d-average);
        }
        stddev/=inp.length;
        stddev=sqrt(stddev);
        String out="average="+ new DecimalFormat("#.##").format(average)+";stddev="+ new DecimalFormat("#.##").format(stddev)+";p95=";
        out+=new DecimalFormat("#.##").format(num[((int)ceil(inp.length*0.95)-1)]);
        System.out.println(out);
        ds.submitData(sc, qc, out);
    }
}
