import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Toy> toys = new ArrayList<Toy>();
        CraneMachine craneMachine = new CraneMachine(toys, 10);
        while (Toy.getMaxToys() < craneMachine.getCapacity()) {
            craneMachine.addToy(toys, "Мягкая игрушка");
        }

        for (Toy toy: toys) {
            toy.setDifficulty(toy.getWeight(), toy.getForm(), toys);
            System.out.println(toy.getDifficulty());
        }

        System.out.println(craneMachine.toString());








    }
}