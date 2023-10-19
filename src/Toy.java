import java.util.Random;

public class Toy {

    static Random random = new Random();
    String name;
    String type;
    double weight;
    String form;
    Integer difficulty;

    private static int uid = 0;

    public Toy(String name) {
        int numName = random.nextInt(7);
        switch (numName) {
            case 0:
                this.type = "Кот";
                break;
            case 1:
                this.type = "Собака";
                break;
            case 2:
                this.type = "Мышка";
                break;
            case 3:
                this.type = "Акула";
                break;
            case 4:
                this.type = "Хомяк";
                break;
            case 5:
                this.type = "Мишка";
                break;
            case 6:
                this.type = "Кролик";
                break;
        }
        int numForm = random.nextInt(3);
        switch (numForm) {
            case 0:
                this.form = "Простая";
                break;
            case 1:
                this.form = "Обычная";
                break;
            case 2:
                this.form = "Сложная";
                break;
        }
        this.weight = random.nextInt( 10,50);
        uid++;
        this.name = name;
    }

    public static int getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return  "\n" + "Мягкая игрушка" + " - " + type + ", весом " + weight + " г." + ", форма - " + form + "\n";
    }


}
