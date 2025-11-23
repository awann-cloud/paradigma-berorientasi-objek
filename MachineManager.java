package ProjekUAS;

import java.util.ArrayList;
import java.util.List;

public class MachineManager {
    private List<Mesin> machines;

    public MachineManager() {
        machines = new ArrayList<>();
        machines.add(new Mesin1("Mesin Mudah", 20, 0.8));
        machines.add(new Mesin2("Mesin Susah", 40, 0.2));
    }

    public List<Mesin> getMachines() {
        return machines;
    }
}

