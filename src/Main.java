public class Main {
    public static void main(String[] args) {
        ToysStore store = new ToysStore();

        store.addToys(1, "Робот", 5, 15);
        store.addToys(1, "Кукла", 10, 10);
        store.addToys(1, "Машинка", 15, 25);
        store.addToys(1, "Конструктор", 20, 20);

        store.shuffleFrequency(1, 25);

        store.gameStart();

        Toys prizeToy = store.getPrizeToys();
        if (prizeToy != null) {
            System.out.println("Выигрыш: " + prizeToy.getName());
        }
    }
}