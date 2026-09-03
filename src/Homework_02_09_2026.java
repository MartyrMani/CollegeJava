public class Homework_02_09_2026 {
    public static void main(String[] args) {
        System.out.println("Моё имя Дарья, мне 19 лет и я живу в Караганде.");

        int age = 19;
        double number = 12.8;
        boolean is_alive = true;
        String greeting = "Hello World!";
        char letter = 'd';

        for (int i = 1; i <= 10; i++) {
            System.out.println(i * 7);
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
