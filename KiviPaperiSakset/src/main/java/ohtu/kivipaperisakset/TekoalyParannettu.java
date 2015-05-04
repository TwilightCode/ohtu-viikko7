package ohtu.kivipaperisakset;

// "Muistava tekoäly"
public class TekoalyParannettu implements Pelaaja {

    private String[] muisti;
    private int vapaaMuistiIndeksi;
    private String syote = "";

    public TekoalyParannettu(int muistinKoko) {
        muisti = new String[muistinKoko];
        vapaaMuistiIndeksi = 0;
    }

    @Override
    public void asetaSiirto(String siirto) {
        // jos muisti täyttyy, unohdetaan viimeinen alkio
        if (vapaaMuistiIndeksi == muisti.length) {
            for (int i = 1; i < muisti.length; i++) {
                muisti[i - 1] = muisti[i];
            }

            vapaaMuistiIndeksi--;
        }

        muisti[vapaaMuistiIndeksi] = siirto;
        vapaaMuistiIndeksi++;
    }

    private String teeSiirto(String vastaus) {
        syote = vastaus;
        return vastaus;
    }

    @Override
    public String annaSiirto() {
        int k = 0;
        int p = 0;
        int s = 0;
        if (vapaaMuistiIndeksi == 0 || vapaaMuistiIndeksi == 1) {
            return teeSiirto("k");
        }

        String viimeisinSiirto = muisti[vapaaMuistiIndeksi - 1];

        for (int i = 0; i < vapaaMuistiIndeksi - 1; i++) {
            if (viimeisinSiirto.equals(muisti[i])) {
                String seuraava = muisti[i + 1];

                if ("k".equals(seuraava)) {
                    k++;
                } else if ("p".equals(seuraava)) {
                    p++;
                } else {
                    s++;
                }
            }
        }

        // Tehdään siirron valinta esimerkiksi seuraavasti;
        // - jos kiviä eniten, annetaan aina paperi
        // - jos papereita eniten, annetaan aina sakset
        // muulloin annetaan aina kivi
        if (k > p && k > s) {
            return teeSiirto("p");
        } else if (p > k && p > s) {
            return teeSiirto("s");
        } else {
            return teeSiirto("k");
        }

        // Tehokkaampiakin tapoja löytyy, mutta niistä lisää 
        // Johdatus Tekoälyyn kurssilla!
    }

    @Override
    public String nimi() {
        return "tietokone Para valitsi: ";
    }

    @Override
    public String syote() {
        return syote + "\n";
    }

}
