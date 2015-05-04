package ohtu.kivipaperisakset;

import java.util.Random;

public class TekoalySatu implements Pelaaja {

    private final Random random = new Random();
    private String syote;

    @Override
    public void asetaSiirto(String Siirto) {
    }

    private String teeSiirto(String vastaus) {
        syote = vastaus;
        return vastaus;
    }

    @Override
    public String annaSiirto() {
        int i = random.nextInt(3);
        if (i == 0) {
            return teeSiirto("k");
        } else if (i == 1) {
            return teeSiirto("p");
        } else if (i == 2) {
            return teeSiirto("s");
        } else {
            return teeSiirto("");
        }
    }

    @Override
    public String nimi() {
        return "tietokone Satu valitsi: ";
    }

    @Override
    public String syote() {
        return syote + "\n";
    }

}
