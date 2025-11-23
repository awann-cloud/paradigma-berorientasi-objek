package ProjekUAS;

public class Mesin1 extends Mesin {
    public Mesin1(String namaMesin, int hargaMain, double successRate) {
        super(namaMesin, hargaMain, successRate);
    }

    public Doll play() {
        return Math.random() <= successRate
            ? new Doll("Boneka Beruang", "Common")
            : null;
    }
}
