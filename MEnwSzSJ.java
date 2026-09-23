
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class MEnwSzSJ {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242");
        DataService ds = (DataService) reg.lookup("RMIDataService");
        int[] inp = (int[]) ds.requestData("B23DCCN863", "MEnwSzSJ");
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < inp.length; i++) {
            if (i == 0) {
                if (inp[0] > inp[1]) {
                    out.add(1);
                }
                ;
            } else if (i == inp.length - 1) {
                if (inp[i] > inp[i - 1]) {
                    out.add(i + 1);
                }
            } else if (inp[i] > inp[i - 1] && inp[i] > inp[i + 1]) {
                out.add(i + 1);
            }
        }
        for (Integer integer : inp) {
            System.out.println(integer);
        }
        for (int i : out) {
            System.out.println(i);
        }
        ds.submitData("B23DCCN863", "MEnwSzSJ", out);
    }
}