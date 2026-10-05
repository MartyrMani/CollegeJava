import java.util.*;

class Student {
    String name;
    String city;
    int age;

    Student(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}

public class Homework_12_09_2026 {
    public static void main(String[] args) {

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
    }

    // Задание 1
    public static void task1() {

        System.out.println("\nЗАДАНИЕ 1");

        ArrayList<String> cities = new ArrayList<>();

        cities.add("Алматы");
        cities.add("Астана");
        cities.add("Караганда");
        cities.add("Кокшетау");
        cities.add("Павлодар");
        cities.add("Шымкент");

        System.out.println("Список до изменений:");

        for (int i = 0; i < cities.size(); i++) {
            System.out.println(i + ": " + cities.get(i));
        }

        cities.remove(2);

        cities.add("Актобе");
        cities.add("Тараз");

        System.out.println("\nСписок после изменений:");

        for (int i = 0; i < cities.size(); i++) {
            System.out.println(i + ": " + cities.get(i));
        }
    }

    // Задание 2
    public static void task2() {

        System.out.println("\nЗАДАНИЕ 2");

        List<Integer> numbers =
                Arrays.asList(3, 5, 3, 8, 5, 1, 8);

        System.out.println("Исходный список:");
        System.out.println(numbers);

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        set.addAll(numbers);

        List<Integer> result = new ArrayList<>(set);

        System.out.println("Без дубликатов:");
        System.out.println(result);
    }

    // Задание 3
    public static void task3() {

        System.out.println("\nЗАДАНИЕ 3");

        HashSet<String> courseA = new HashSet<>();

        courseA.add("Анна");
        courseA.add("Иван");
        courseA.add("Мария");
        courseA.add("Алексей");

        HashSet<String> courseB = new HashSet<>();

        courseB.add("Иван");
        courseB.add("Мария");
        courseB.add("Данияр");
        courseB.add("Ольга");

        System.out.println("Курс A: " + courseA);
        System.out.println("Курс B: " + courseB);

        HashSet<String> intersection =
                new HashSet<>(courseA);

        intersection.retainAll(courseB);

        System.out.println(
                "Оба курса: " + intersection
        );

        HashSet<String> union =
                new HashSet<>(courseA);

        union.addAll(courseB);

        System.out.println(
                "Хотя бы один курс: " + union
        );

        HashSet<String> difference =
                new HashSet<>(courseA);

        difference.removeAll(courseB);

        System.out.println(
                "Только курс A: " + difference
        );
    }

    // Задание 4
    public static void task4() {

        System.out.println("\nЗАДАНИЕ 4");

        TreeSet<Integer> numbers = new TreeSet<>();

        Random random = new Random();

        while (numbers.size() < 10) {
            numbers.add(random.nextInt(100) + 1);
        }

        System.out.println("TreeSet:");
        System.out.println(numbers);

        System.out.println(
                "Первый элемент: " + numbers.first()
        );

        System.out.println(
                "Последний элемент: " + numbers.last()
        );

        System.out.println(
                "Числа меньше 50: " + numbers.headSet(50)
        );

        System.out.println(
                "Числа от 20 до 80: "
                        + numbers.subSet(20, 80)
        );
    }

    // Задание 5
    public static void task5() {

        System.out.println("\nЗАДАНИЕ 5");

        String text =
                "java python java sql java python csharp";

        String[] words = text.split(" ");

        HashMap<String, Integer> frequency =
                new HashMap<>();

        for (String word : words) {

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
            );
        }

        List<Map.Entry<String, Integer>> result =
                new ArrayList<>(frequency.entrySet());

        result.sort(
                Map.Entry
                        .<String, Integer>comparingByValue()
                        .reversed()
        );

        System.out.println("Частота слов:");

        for (Map.Entry<String, Integer> entry : result) {

            System.out.println(
                    entry.getKey()
                            + " - "
                            + entry.getValue()
            );
        }
    }

    // Задание 6
    public static void task6() {

        System.out.println("\nЗАДАНИЕ 6");

        List<Student> students = new ArrayList<>();

        students.add(
                new Student("Анна", "Астана", 19)
        );

        students.add(
                new Student("Иван", "Алматы", 18)
        );

        students.add(
                new Student("Мария", "Астана", 20)
        );

        students.add(
                new Student("Данияр", "Караганда", 19)
        );

        students.add(
                new Student("Ольга", "Алматы", 18)
        );

        Map<String, List<Student>> studentsByCity =
                new HashMap<>();

        for (Student student : students) {

            studentsByCity
                    .computeIfAbsent(
                            student.city,
                            city -> new ArrayList<>()
                    )
                    .add(student);
        }

        System.out.println("Группировка по городам:");

        for (Map.Entry<String, List<Student>> entry
                : studentsByCity.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + ": "
                            + entry.getValue()
            );
        }
    }

    // Задание 7
    public static void task7() {

        System.out.println("\nЗАДАНИЕ 7");

        List<Student> students = new ArrayList<>();

        students.add(
                new Student("Анна", "Астана", 19)
        );

        students.add(
                new Student("Иван", "Алматы", 18)
        );

        students.add(
                new Student("Мария", "Астана", 20)
        );

        students.add(
                new Student("Алексей", "Павлодар", 18)
        );

        students.add(
                new Student("Данияр", "Караганда", 19)
        );

        System.out.println("До сортировки:");

        for (Student student : students) {
            System.out.println(student);
        }

        students.sort(
                Comparator
                        .comparingInt(
                                (Student student) -> student.age
                        )
                        .thenComparing(
                                student -> student.name
                        )
        );

        System.out.println("\nПосле сортировки:");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Задание 8
    public static void task8() {

        System.out.println("\nЗАДАНИЕ 8");

        Integer[] array = new Integer[15];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {

            array[i] =
                    random.nextInt(100) + 1;
        }

        System.out.println("Исходный массив:");

        System.out.println(
                Arrays.toString(array)
        );

        List<Integer> numbers =
                new ArrayList<>(
                        Arrays.asList(array)
                );

        Collections.sort(numbers);

        System.out.println(
                "Отсортированный список:"
        );

        System.out.println(numbers);

        int index =
                Collections.binarySearch(
                        numbers,
                        42
                );

        if (index >= 0) {

            System.out.println(
                    "Число 42 найдено. Индекс: "
                            + index
            );

        } else {

            System.out.println(
                    "Числа 42 в списке нет"
            );
        }

        int min = numbers.get(0);

        int max =
                numbers.get(
                        numbers.size() - 1
                );

        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        System.out.println(
                "Минимум: " + min
        );

        System.out.println(
                "Максимум: " + max
        );

        System.out.println(
                "Сумма: " + sum
        );
    }
}
