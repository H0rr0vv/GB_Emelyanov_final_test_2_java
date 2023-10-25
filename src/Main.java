import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sm = new Scanner(System.in);
        List<Toy> toys = new ArrayList<Toy>();
        CraneMachine craneMachine = new CraneMachine(toys, 10);
        while (Toy.getMaxToys() < craneMachine.getCapacity()) {
            craneMachine.addToy(toys, "Мягкая игрушка");
        }

        for (Toy toy : toys) {
            toy.setDifficulty(toy.getWeight(), toy.getForm(), toys);
        }
        Toy prize = new Toy();


        boolean flag = true;
        try {
            while (flag) {
                System.out.println(craneMachine.actionMenuText());
                switch (sm.nextInt()) {
                    case 1:
                        System.out.println(craneMachine.toString());
                        System.out.println("Выберете желаемую игрушку");
                        int newTarget = sc.nextInt();
                        craneMachine.checkTarget(newTarget);
                        craneMachine.setTarget(newTarget);
                        break;
                    case 2:
                        System.out.println("Игра началась");
                        if (!CraneMachine.isWin()) {
                            craneMachine.trial(toys, craneMachine.getTarget(), craneMachine.getCranePower(), prize);
                            craneMachine.removeToy(toys, prize);
                        }
                        craneMachine.timeOutOneSecond();
                        System.out.println(".");
                        craneMachine.timeOutOneSecond();
                        System.out.println("..");
                        craneMachine.timeOutOneSecond();
                        System.out.println("...");
                        System.out.println("Конец игры");
                        break;
                    case 3:
                        if (CraneMachine.isWin()) {
                            craneMachine.winToString(prize);
                        } else {
                            System.out.println("Вы ничего не выиграли. Может повезет в следующий раз.");
                        }
                        craneMachine.resetWin();
                        break;
                    case 4:
                        flag = false;
                        break;
                    default:
                        System.out.println("Ошибка. Такого пункта меню нет.");
                }
            }
        } catch (TargetException e) {
            System.out.println(e.getMessage());
        }
    }
}