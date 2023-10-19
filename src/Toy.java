public class Toy {

    String name;
    String type;
    double weight;
    String form;
    Integer difficulty;

    private static int uid = 0;

    public Toy(String name) {
        int numName = (int) Math.random() * (7);
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
        int numform = (int) Math.random() * (3);
        switch (numName) {
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
        this.weight = 1+ Math.random() * (51);
        uid++;
    }

    public static int getUid() {
        return uid;
    }

    @Override
    public String toString() {
        return  name + " - " + type + ", весом " + weight + " г." + ", форма - " + form;
    }
}
