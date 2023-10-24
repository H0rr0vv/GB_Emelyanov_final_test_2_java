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
        Toy prize = new Toy();
        System.out.println(craneMachine.actionMenuText());





        Integer switchMenu = sc.nextInt();
        boolean flag = true;
        while (flag) {
            try {
                switch (switchMenu) {
                    case 1:
                        System.out.println(craneMachine.toString());
                        int newTarget = craneMachine.checkTarget(sc.nextInt());
                        craneMachine.setTarget(newTarget);
                        System.out.println(craneMachine.actionMenuText());
                        break;
                    case 2:
                        if (CraneMachine.isWin()) {
                            craneMachine.trial(toys, craneMachine.getTarget(), craneMachine.getCranePower(), prize);
                            craneMachine.removeToy(toys,prize);
                            System.out.println(craneMachine.actionMenuText());
                            break;
                        }
                    case 3:
                        if(CraneMachine.isWin()){
                            craneMachine.winToString(prize);
                        }
                        else {
                            System.out.println("Вы ничего не выиграли. Может повезет в следующий раз.");
                        }
                        flag = false;
                        break;
                }
            } catch (TargetException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}