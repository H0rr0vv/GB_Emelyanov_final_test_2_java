import java.util.List;
import java.util.Random;

public class Toy {

    static Random random = new Random();
    private String name;
    private String type;
    private int weight;
    private String form;
    private Integer difficulty;
    private int uid;
    private static int maxToys = 0;


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
        this.weight = random.nextInt( 100,300);
        maxToys++;
        uid++;
        this.uid = maxToys;
        this.name = name;
    }

    public static int getMaxToys() {
        return maxToys;
    }

    public void setDifficulty(int weight, String form, List<Toy> toys) {
        int formFactor = 2;
        switch (form) {
            case "Простая":
                formFactor = 1;
                break;
            case "Обычная":
                formFactor = 2;
                break;
            case "Сложная":
                formFactor = 5;
                break;
        }
        difficulty = weight / 10 * formFactor + (toys.indexOf(this) * -1);
        this.difficulty = difficulty;
    }

    public int getWeight() {
        return weight;
    }

    public String getForm() {
        return form;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return  "\n" + uid + ": Мягкая игрушка" + " - " + type + ", весом " + weight + " г." + ", форма - " + form + "\n";
    }


}
