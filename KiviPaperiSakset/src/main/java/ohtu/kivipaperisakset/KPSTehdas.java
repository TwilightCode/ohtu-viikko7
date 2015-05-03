package ohtu.kivipaperisakset;

import java.util.HashMap;

public class KPSTehdas {

    private HashMap<String, Peli> pelit;

    public KPSTehdas(IO lukija) {
        pelit = new HashMap<String, Peli>();
        pelit.put("a", new KPSPelaajaVsPelaaja(lukija));
        pelit.put("b", new KPSTekoaly(lukija, new TekoalyPerus()));
        pelit.put("c", new KPSTekoaly(lukija, (new TekoalyParannettu(20))));
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
