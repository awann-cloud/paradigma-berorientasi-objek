package ProjekUAS;

public class Mesin2 extends Mesin {
    public Mesin2(String namaMesin, int hargaMain, double successRate) {
        super("Mesin Epic", 40, 0.4);

        addDoll(new CommonDoll("Shinobu Kocho (Hashira Serangga)", "Epic"));
        addDoll(new CommonDoll("Mitsuri Kanroji (Hashira Cinta)", "Epic"));
        addDoll(new CommonDoll("Obanai Iguro (Hashira Ular)", "Epic"));
        addDoll(new CommonDoll("Gyutaro (Upper Rank Six)", "Epic"));
        addDoll(new CommonDoll("Gyokko (Upper Rank Five)", "Epic"));
    }

    public Doll play() {
        double chance = rand.nextDouble();

        if (chance > successRate) {
            return null;
        }

        return listDoll.get(rand.nextInt(listDoll.size()));
    }
}
