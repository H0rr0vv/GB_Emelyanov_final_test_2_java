import java.util.ArrayList;
import java.util.List;

public class CraneMachine {

    private List<Toy> toys;
    private int capacity;
    private int cranePower;

    public int getCapacity() {
        return capacity;
    }

    public CraneMachine(List<Toy> toys, int capacity) {
        this.toys = toys;
        this.capacity = capacity;
    }

    public List<Toy> addToy(List<Toy> toys, String name) {
        Toy toy = new Toy(name + Toy.getMaxToys());
        toys.add(toy);
        return toys;
    }

    @Override
    public String toString() {
        return "В автомате сейчас находится " + Toy.getMaxToys() + " игрушек: " + '\n' + toys;
    }
}
