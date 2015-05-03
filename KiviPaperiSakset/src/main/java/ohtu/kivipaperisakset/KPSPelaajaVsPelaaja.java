package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja implements Peli {

    IO lukija;

    public KPSPelaajaVsPelaaja(IO lukija) {
        this.lukija = lukija;
    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        String ekanSiirto;
        String tokanSiirto;

        while (tuomari.jatketaanko()) {
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = lukija.lueSyote();
            System.out.print("Toisen pelaajan siirto: ");
            tokanSiirto = lukija.lueSyote();

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            tuomari.tilanne();
        }
        tuomari.lopetus();
    }

}
