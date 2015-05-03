package ohtu.kivipaperisakset;

public class TekoalyPerus implements Pelaaja {

    int siirto;
    String syote;

    public TekoalyPerus() {
        siirto = 0;
    }

    private String teeSiirto(String vastaus) {
        syote = vastaus;
        return vastaus;
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return teeSiirto("k");
        } else if (siirto == 1) {
            return teeSiirto("p");
        } else {
            return teeSiirto("s");
        }

    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }

    @Override
    public String toString() {
        return "tietokone valitsi" + syote + "\n";
    }

    @Override
    public String nimi() {
        return "tietokone valitsi: ";
    }

    @Override
    public String syote() {
        return syote + "\n";
    }

}
