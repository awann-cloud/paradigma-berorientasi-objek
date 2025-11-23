package ProjekUAS;

public class Doll {
    private String namaBoneka;
    private String rarity;

    public Doll(String namaBoneka, String rarity) {
        this.namaBoneka = namaBoneka;
        this.rarity = rarity;
    }

    public String getNamaBoneka() {
        return namaBoneka;
    }

    public String getRarity() {
        return rarity;
    }
}
