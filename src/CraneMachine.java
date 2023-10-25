import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CraneMachine {


    static Random random = new Random();
    private static boolean win = false;
    Scanner sc = new Scanner(System.in);
    private List<Toy> toys;
    private int capacity;
    private int cranePower;
    private int target;

    public CraneMachine(List<Toy> toys, int capacity) {
        this.toys = toys;
        this.capacity = capacity;
        this.cranePower = capacity * 10;
    }

    public static boolean isWin() {
        return win;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Toy> addToy(List<Toy> toys, String name) {
        Toy toy = new Toy(name + Toy.getMaxToys());
        toys.add(toy);
        return toys;
    }

    public List<Toy> removeToy(List<Toy> toys, Toy prize) {
        for (Toy t : toys) {
            if (prize.equals(t)) {
                toys.remove(t);
            }
        }
        int newUid = 1;
        for (Toy toy : toys) {
            toy.setUid(newUid);
            newUid++;
        }
        return toys;
    }

    public Toy trial(List<Toy> toys, int target, int cranePower, Toy prize) {
        int currentlyCranePower = random.nextInt(cranePower);
        for (Toy t : toys) {
            if (target == t.getUid()) {
                if (currentlyCranePower > t.getDifficulty()) {
                    prize = t;
                    win = true;
                }
            }
        }
        return prize;
    }

    public int checkTarget(int uidTarget) throws TargetException {
        if (uidTarget > Toy.getMaxToys() || uidTarget < 0) {
            throw new TargetException("Ошибка. Введено неверное id игрушки.");
        }
        return uidTarget;
    }

    public Toy getPrize(Toy prize) {
        return prize;
    }

    public int getCranePower() {
        return cranePower;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "В автомате сейчас находится " + Toy.getMaxToys() + " игрушек: " + '\n' + toys;
    }

    public String winToString(Toy prize) {
        return "Вы выиграли: " + '\n' + prize.toString();
    }

    public final String actionMenuText() {
        return "Выберите действие:" + '\n' +
                "1. Выбрать игрушку" + '\n' +
                "2. Начать" + '\n' +
                "3. Забрать приз" + '\n';
    }

    public void timeOutOneSecond(){
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }


}
