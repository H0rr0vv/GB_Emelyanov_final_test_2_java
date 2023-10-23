import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CraneMachine {


    Scanner sc = new Scanner(System.in);
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

    public List<Toy> trial(List<Toy> toys, int target, int cranePower, List<Toy> prize) {
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

    public int checkTarget(int uidTarget) throws TargetException{
        if (uidTarget > Toy.getMaxToys() || uidTarget < 0){
            throw new TargetException("Ошибка. Введено неверное id игрушки.");
        }
        return uidTarget;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getCranePower() {
        return cranePower;
    }

    public int getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "В автомате сейчас находится " + Toy.getMaxToys() + " игрушек: " + '\n' + toys;
    }

    public final String actionMenuText() {
        return "Выберите действие:" + '\n' +
                "1. Выбрать игрушку" + '\n' +
                "2. Начать" + '\n' +
                "1. Забрать приз" + '\n';
    }


}
