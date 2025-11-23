package ProjekUAS;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Doll> dolls;

    public Inventory() {
        dolls = new ArrayList<>();
    }

    public void addDoll(Doll doll) {
        dolls.add(doll);
    }

    public List<Doll> getDolls() {
        return dolls;
    }
}
