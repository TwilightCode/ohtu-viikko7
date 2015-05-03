package ohtu.kivipaperisakset;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly implements Peli {

    IO lukija;

    public KPSParempiTekoaly(IO lukija) {
        this.lukija = lukija;
    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);
        String ekanSiirto;
        String tokanSiirto;

        while (tuomari.jatketaanko()) {
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = lukija.lueSyote();
            tokanSiirto = tekoaly.annaSiirto();
            System.out.println("Tietokone valitsi: " + tokanSiirto);

            tekoaly.asetaSiirto(ekanSiirto);
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            tuomari.tilanne();
        }
        tuomari.lopetus();
    }

}
