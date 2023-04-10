import java.io.FileWriter;
import java.util.ArrayList;

public class ToysStore {
    private ArrayList<Toys> toys;
    private ArrayList<Toys> prizeToys;

    public ToysStore() {
        toys = new ArrayList<Toys>();
        prizeToys = new ArrayList<Toys>();
    }

    public void addToys(int id, String name, int quantity, double frequency) {
        Toys toy = new Toys(id, name, quantity, frequency);
        toys.add(toy);
    }

    public void shuffleFrequency(int id, double frequency) {
        for (Toys toy : toys) {
            if (toy.getId() == id) {
                toy.setFrequency(frequency);
            }
        }
    }

    public void gameStart() {
        prizeToys.clear();

        for (Toys toy : toys) {
            double random = Math.random() * 100;
            if (random < toy.getFrequency()) prizeToys.add(toy);
        }
    }

    public Toys getPrizeToys() {
        if (!prizeToys.isEmpty()) {
            Toys prizeToy = prizeToys.remove(0);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);

            try {
                FileWriter writer = new FileWriter("prizeFile.txt", true);
                writer.write(prizeToy.getName() + "\n");
                writer.close();
            } catch (Exception e) {
                System.out.println("Ошибка!");
            }
            return prizeToy;
        } else {
            System.out.println("Игрушки кончились!");
            return null;
        }
    }
}
