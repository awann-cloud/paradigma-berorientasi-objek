package ProjekUAS;

public class Mesin1 extends Mesin {
    public Mesin1(String namaMesin, int hargaMain, double successRate) {
        super("Mesin Common", 20, 0.8);

        addDoll(new CommonDoll("Sumi Nakahara", "Common"));
        addDoll(new CommonDoll("Kiyo Terauchi", "Common"));
        addDoll(new CommonDoll("Goto (Kakushi Goto)", "Common"));
        addDoll(new CommonDoll("Tongue Demon", "Common"));
        addDoll(new CommonDoll("Spider Demon Mother", "Common"));
    }

    public Doll play() {
        double chance = rand.nextDouble();

        if (chance > successRate) {
            return null;
        }

        return listDoll.get(rand.nextInt(listDoll.size()));
    }
}
