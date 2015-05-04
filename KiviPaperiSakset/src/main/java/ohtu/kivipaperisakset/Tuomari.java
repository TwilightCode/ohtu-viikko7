package ohtu.kivipaperisakset;

// Tuomari pitää kirjaa ensimmäisen ja toisen pelaajan pisteistä sekä tasapelien määrästä.
public class Tuomari {

    private int ekanPisteet;
    private int tokanPisteet;
    private int tasapelit;
    private boolean jatkuu;
    private int vuoro = 0;

    public Tuomari() {
        this.ekanPisteet = 0;
        this.tokanPisteet = 0;
        this.tasapelit = 0;
        this.jatkuu = true;
    }

    private boolean tarkistaSiirtojenOikeellisuus(String ekanSiirto, String tokanSiirto) {
        return (onkoOkSiirto(ekanSiirto) == true) && (onkoOkSiirto(tokanSiirto) == true);
    }

    public void kirjaaSiirto(String ekanSiirto, String tokanSiirto) {
        if (!tarkistaSiirtojenOikeellisuus(ekanSiirto, tokanSiirto)) {
            jatkuu = false;
            return;
        }
        if (tasapeli(ekanSiirto, tokanSiirto)) {
            tasapelit++;
        } else if (ekaVoittaa(ekanSiirto, tokanSiirto)) {
            ekanPisteet++;
        } else {
            tokanPisteet++;
        }
    }

    // sisäinen metodi, jolla tarkastetaan tuliko tasapeli
    private static boolean tasapeli(String eka, String toka) {
        return eka.equals(toka);
    }

    // sisäinen metodi joka tarkastaa voittaako eka pelaaja tokan
    private static boolean ekaVoittaa(String eka, String toka) {
        if ("k".equals(eka) && "s".equals(toka)) {
            return true;
        } else if ("s".equals(eka) && "p".equals(toka)) {
            return true;
        } else if ("p".equals(eka) && "k".equals(toka)) {
            return true;
        }

        return false;
    }

    public boolean jatketaanko() {
        vuoro++;
        if (vuoro > 500) {
            return false;
        }
        return jatkuu;
    }

    private boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    public void tilanne() {
        System.out.println(toString() + "\n");
    }

    public void lopetus() {
        System.out.println("\n" + "Kiitos!" + "\n" + toString());
    }

    @Override
    public String toString() {
        String s = "Pelitilanne: " + ekanPisteet + " - " + tokanPisteet + "\n" + "Tasapelit: " + tasapelit;
        return s;
    }

}
