import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CraneMachine {


    static Random random = new Random();
    private List<Toy> toys;
    private int capacity;
    private int cranePower;
    private int target;

    public int getCapacity() {
        return capacity;
    }

    public CraneMachine(List<Toy> toys, int capacity) {
        this.toys = toys;
        this.capacity = capacity;
        this.cranePower = capacity * 10;
    }

    public List<Toy> addToy(List<Toy> toys, String name) {
        Toy toy = new Toy(name + Toy.getMaxToys());
        toys.add(toy);
        return toys;
    }

    public List<Toy> removeToy(List<Toy> toys, List<Toy> prize){
        toys.remove(prize.get(0).getUid()-1);
        int newUid = 1;
        for (Toy toy: toys){
            toy.setUid(newUid);
            newUid++;
        }
        return toys;
    }

    public List<Toy> trial(List<Toy> toys, int target, int cranePower) {
        List<Toy> prize = new ArrayList<>();
        int currentlyCranePower = random.nextInt(cranePower);
        for(Toy t: toys){
            if (target == t.getUid()) {
                if (currentlyCranePower > t.getDifficulty()) {
                    prize.add(0, t);
                }
            }
        }
        return prize;
    }

    public int getCranePower() {
        return cranePower;
    }

    @Override
    public String toString() {
        return "В автомате сейчас находится " + Toy.getMaxToys() + " игрушек: " + '\n' + toys;
    }
}
