import RMI.CharacterService;
import java.net.URI;
import java.rmi.registry.*;
public class YeMDbAaB {
    public static void main(String[] args) throws Exception{
        Registry reg = LocateRegistry.getRegistry("36.50.135.242",1099);
        CharacterService cs = (CharacterService) reg.lookup("RMICharacterService");
        String inp= cs.requestCharacter("B23DCCN863", "YeMDbAaB");
        cs.submitCharacter("B23DCCN863", "YeMDbAaB", new URI(null,null,inp,null).toASCIIString());
    }
}
