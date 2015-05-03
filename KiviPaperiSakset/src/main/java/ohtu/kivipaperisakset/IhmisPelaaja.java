package ohtu.kivipaperisakset;

public class IhmisPelaaja implements Pelaaja {

    IO lukija;

    public IhmisPelaaja(IO lukija) {
        this.lukija = lukija;
    }

    @Override
    public void asetaSiirto(String Siirto) {
    }

    @Override
    public String annaSiirto() {
        return lukija.lueSyote();
    }

    @Override
    public String nimi() {
        return "pelaajan siirto: ";
    }

    @Override
    public String syote() {
        return "";
    }

}
