package ohtu.kivipaperisakset;

public class Paaohjelma {

    public static void main(String[] args) {
        IO lukija = new SyotteenLukija();
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = lukija.lueSyote();
            KPSTehdas pelitehdas = new KPSTehdas();
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            pelitehdas.hae(vastaus).pelaa();
            break;
        }

    }
}
