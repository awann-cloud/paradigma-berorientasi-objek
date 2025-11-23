package ProjekUAS;

public abstract class Mesin {
    protected String namaMesin;
    protected int hargaMain;
    protected double successRate;

    public Mesin(String namaMesin, int hargaMain, double successRate) {
        this.namaMesin = namaMesin;
        this.hargaMain = hargaMain;
        this.successRate = successRate;
    }

    public abstract Doll play();
}
