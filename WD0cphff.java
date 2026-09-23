
import RMI.ObjectService;
import RMI.TicketSla;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WD0cphff {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242");
        ObjectService os = (ObjectService) reg.lookup("RMIObjectService");
        String sc = "B23DCCN863";
        String qc = "WD0cphff";
        TicketSla ts= (TicketSla)os.requestObject(sc, qc);
        String pri=ts.getPriority();
        int hours= ts.getOpenedHoursAgo();
        if((pri.equals("CRITICAL") && hours>2)||(pri.equals("HIGH")&&hours>8)||(pri.equals("MEDIUM")&&hours>24)||(pri.equals("LOW")&&hours>72)){
            ts.setBreached(true);
        }
        if(ts.getBreached()){
            if(pri.equals("CRITICAL")||hours>96){
                ts.setAction("ESCALATE_L2");
            } else ts.setAction("ESCALATE_L1");
        } else ts.setAction("MONITOR");
        os.submitObject(sc, qc, ts);
    }
}
