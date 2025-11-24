package ProjekUAS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Mesin {
    protected String namaMesin;
    protected int hargaMain;
    protected double successRate;
    protected List<Doll> listDoll;
    protected Random rand = new Random();

    public Mesin(String namaMesin, int hargaMain, double successRate) {
        this.namaMesin = namaMesin;
        this.hargaMain = hargaMain;
        this.successRate = successRate;
        listDoll = new ArrayList<>();
    }

    public String getNamaMesin() {
        return this.namaMesin;
    }
    
    public void addDoll(Doll d) {
        listDoll.add(d);
    }

    public void lihatDaftarHadiah() {
        System.out.println("=== DAFTAR HADIAH DI " + this.namaMesin + " ===");
        for (int i = 0; i < listDoll.size(); i++) {
            Doll d = listDoll.get(i);
            System.out.println((i + 1) + ". " + d.getNamaBoneka() + " (" + d.getRarity() + ")");
        }
    }

    public abstract Doll play();
}
