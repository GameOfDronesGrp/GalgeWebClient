/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;



interface GalgeClientI {
    public ArrayList<String> getBrugteBogstaver();
    public String getSynligtOrd();
    public String getOrdet();
    public int getAntalForkerteBogstaver();
    public boolean erSidsteBogstavKorrekt();
    public boolean erSpilletVundet();
    public boolean erSpilletTabt();
    public boolean erSpilletSlut();
    public void nulstil();
    public void opdaterSynligtOrd();
    public void gætBogstav(String bogstav);
    public boolean hentBruger(String brugernavn, String password) throws java.rmi.RemoteException;;

           
}
