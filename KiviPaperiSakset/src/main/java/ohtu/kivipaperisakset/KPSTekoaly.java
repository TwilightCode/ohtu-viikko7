package ohtu.kivipaperisakset;

public class KPSTekoaly implements Peli {

    IO lukija;
    Tekoaly tekoaly;

    public KPSTekoaly(IO lukija, Tekoaly tekoaly) {
        this.lukija = lukija;
        this.tekoaly = tekoaly;
    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
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
