package ohtu.kivipaperisakset;

public class KPS implements Peli {

    Pelaaja pelaaja1;
    Pelaaja pelaaja2;

    protected KPS(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }

    public static KPS LuoPelaajaVspelaaja(IO lukija) {
        return new KPS(new IhmisPelaaja(lukija), new IhmisPelaaja(lukija));
    }

    public static KPS LuoPelaajaVstekoaly(IO lukija) {
        return new KPS(new IhmisPelaaja(lukija), new TekoalyPerus());
    }

    public static KPS LuoPelaajaVsParanneltuTekoaly(IO lukija) {
        return new KPS(new IhmisPelaaja(lukija), new TekoalyParannettu(20));
    }

    public static KPS LuoTekoalyVsParanneltuTekoaly() {
        return new KPS(new TekoalyPerus(), new TekoalyParannettu(20));
    }

    private String pyydaSiirto(Pelaaja pelaaja) {
        String apu;
        System.out.print(pelaaja.nimi());
        apu = pelaaja.annaSiirto();
        System.out.print(pelaaja.syote());
        return apu;
    }

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();
        String ekanSiirto;
        String tokanSiirto;

        while (tuomari.jatketaanko()) {
            ekanSiirto = pyydaSiirto(pelaaja1);
            tokanSiirto = pyydaSiirto(pelaaja2);

            pelaaja1.asetaSiirto(tokanSiirto);
            pelaaja2.asetaSiirto(ekanSiirto);

            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            tuomari.tilanne();
        }
        tuomari.lopetus();
    }

}
