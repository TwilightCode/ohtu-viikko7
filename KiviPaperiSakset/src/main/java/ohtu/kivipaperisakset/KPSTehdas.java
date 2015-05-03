package ohtu.kivipaperisakset;

import java.util.HashMap;

public class KPSTehdas {

    private HashMap<String, Peli> pelit;

    public KPSTehdas(IO lukija) {
        pelit = new HashMap<String, Peli>();
        pelit.put("a", KPS.LuoPelaajaVspelaaja(lukija));
        pelit.put("b", KPS.LuoPelaajaVstekoaly(lukija));
        pelit.put("c", KPS.LuoPelaajaVsParanneltuTekoaly(lukija));
        pelit.put("tuntematon", new Tuntematon());
    }

    public Peli hae(String operaatio) {
        Peli peli = pelit.get(operaatio);
        if (peli == null) {
            peli = pelit.get("tuntematon");
        }
        return peli;
    }

}
