
import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class M2m0dwbe {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry("36.50.135.242", 1099);
        CharacterService cs = (CharacterService) reg.lookup("RMICharacterService");
        int inp = Integer.parseInt(cs.requestCharacter("B23DCCN863", "M2m0dwbe"));
        String out = "";
        if ((inp / 1000) == 9) {
            out += "IX";
            inp -= 9000;
        }
        if ((inp / 1000) == 4) {
            out += "IV";
            inp -= 4000;
        }
        while (inp >= 1000) {
            out += "M";
            inp -= 1000;
        }
        if ((inp / 100) == 9) {
            out += "IX";
            inp -= 900;
        }
        if ((inp / 100) == 4) {
            out += "IV";
            inp -= 400;
        }
        while (inp >= 500) {

            out += "D";
            inp -= 500;
        }
        while (inp >= 100) {
            out += "C";
            inp -= 100;
        }
        if ((inp / 10) == 9) {
            out += "IX";
            inp -= 90;
        }
        if ((inp / 10) == 4) {
            out += "IV";
            inp -= 40;
        }
        while (inp >= 50) {
            out += "L";
            inp -= 50;
        }
        while (inp >= 10) {
            out += "X";
            inp -= 10;
        }
        if (inp== 9) {
            out += "IX";
            inp -= 9;
        }
        if (inp== 4) {
            out += "IV";
            inp -= 4;
        }
        while (inp >= 5) {
            out += "V";
            inp -= 5;
        }
        while (inp >= 1) {
            out += "I";
            inp -= 1;
        }
        System.out.print(out);
        cs.submitCharacter("B23DCCN863", "M2m0dwbe", out);
    }
}
