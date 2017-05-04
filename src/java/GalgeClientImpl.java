
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;
import sh.surge.galgeleg.wsdl.Galgelogik;
import sh.surge.galgeleg.wsdl.GalgelogikService;

/**
 *
 * @author mohammad
 */
public class GalgeClientImpl implements GalgeClientI{
        
    @WebServiceRef
    static GalgelogikService service;

    static Galgelogik port;

    private Galgelogik getPort(){
        System.out.println("Obtain port from service");
        port = service.getPort(Galgelogik.class);
        return port;
    }

    public GalgeClientImpl(){
        try{
            service = new GalgelogikService();
            getPort();
            printSessionInfo();
        }catch(Exception e){
            System.out.println("Det er ikke muligt at oprette forbindelse til serveren!");
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args) {
        try {
            service = new GalgelogikService();
            GalgeClientImpl client = new GalgeClientImpl();
            //client.getPort();
            //client.printSessionInfo();
            System.out.println("Ordet du skal gætte er :"+ port.getOrdet());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }*/
    
    @Override
    public ArrayList<String> getBrugteBogstaver() {
        return (ArrayList<String>) port.getBrugteBogstaver();
    }

    @Override
    public String getSynligtOrd() {
        return port.getSynligtOrd();
    }

    @Override
    public String getOrdet() {
        return port.getOrdet();
    }

    @Override
    public int getAntalForkerteBogstaver() {
        return port.getAntalForkerteBogstaver();
    }

    @Override
    public boolean erSidsteBogstavKorrekt() {
        return port.erSidsteBogstavKorrekt();
    }

    @Override
    public boolean erSpilletVundet() {
        return port.erSpilletVundet();
    }

    @Override
    public boolean erSpilletTabt() {
        return port.erSpilletTabt();
    }

    @Override
    public boolean erSpilletSlut() {
        return port.erSpilletSlut();
    }

    @Override
    public void nulstil() {
        port.nulstil();
    }

    @Override
    public void opdaterSynligtOrd() {
        port.opdaterSynligtOrd();
    }

    @Override
    public void gætBogstav(String bogstav) {
        port.gætBogstav(bogstav);
    }

    @Override
    public boolean hentBruger(String brugernavn, String password) throws RemoteException {
        return port.hentBruger(password, password);
    }
    
    public void printSessionInfo() {
        try {
//            System.out.println("SESSION_MAINTAIN not set all session ids are new");
//            System.out.println(port.printSessionInfo());
//            System.out.println(port.printSessionInfo());
            System.out.println("Invoking printSessionInfo operation ...");
            Map requestContext =
                ((BindingProvider) port).getRequestContext();
            requestContext.put(
                BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
            System.out.println("SESSION_MAINTAIN is set all session ids are same");
            System.out.println(port.printSessionInfo());
            System.out.println(port.printSessionInfo());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}