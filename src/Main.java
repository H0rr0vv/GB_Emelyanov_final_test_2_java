import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Toy> toys = new ArrayList<Toy>();
        CraneMachine craneMachine = new CraneMachine(toys, 10);
        while (Toy.getUid() < craneMachine.getCapacity()) {
            craneMachine.addToy(toys, "Мягкая игрушка");
        }

        Toy toy = new Toy("Игрушка");
        toy.toString();
        craneMachine.toString();





    }
}