package ohtu.kivipaperisakset;

public class KPSTekoaly implements Peli {

    IO lukija;

    public KPSTekoaly(IO lukija) {
        this.lukija = lukija;
    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        Tekoaly tekoaly = new Tekoaly();
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
