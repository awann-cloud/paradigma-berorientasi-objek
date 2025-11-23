package ProjekUAS;

public class Mesin2 extends Mesin {
    public Mesin2(String namaMesin, int hargaMain, double successRate) {
        super(namaMesin, hargaMain, successRate);
    }

    public Doll play() {
        return Math.random() <= successRate
            ? new Doll("Boneka Anjing", "Legendary")
            : null;
    }
}
