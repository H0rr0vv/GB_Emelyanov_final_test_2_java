import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Toy> toys = new ArrayList<Toy>();
        CraneMachine craneMachine = new CraneMachine(toys, 10);
        while (Toy.getMaxToys() < craneMachine.getCapacity()) {
            craneMachine.addToy(toys, "Мягкая игрушка");
        }

        for (Toy toy: toys) {
            toy.setDifficulty(toy.getWeight(), toy.getForm(), toys);
        }
        List<Toy> prize = new ArrayList<Toy>(1);



        System.out.println(craneMachine.toString());
        System.out.println(craneMachine.actionMenuText());

        Integer switchMenu = sc.nextInt();
        boolean flag = true;
        while (flag){
            try{
                switch(switchMenu){
                    case 1:
                        int newTarget = craneMachine.checkTarget(sc.nextInt());
                        craneMachine.setTarget(newTarget);
                        break;
                    case 2:
                        craneMachine.trial(toys, craneMachine.getTarget(), craneMachine.getCranePower(), prize);
                        break;
                    case 3:
                        break;
                }
            } catch (TargetException e) {
                System.out.println(e.getMessage());
            } catch () {

            }
        }

        craneMachine.trial(toys, 2, craneMachine.getCranePower(), prize);

        System.out.println(prize.toString());

        craneMachine.removeToy(toys,prize);

        System.out.println(toys.toString());
    }
}