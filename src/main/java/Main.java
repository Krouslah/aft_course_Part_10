import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        Scanner src = new Scanner(System.in);
        System.out.println("Введите целевую строку:");
        StringHelper stringHelper = new StringHelper(src.nextLine());
        System.out.println("\n" + stringHelper.getWordsCount() + " - Количество слов");
        if (stringHelper.cut().equals("0")) {
            System.out.println("Введена пустая строка");
        } else {
            System.out.println("Полученная строка после работы метода cut():\n" + stringHelper.cut());
        }
        System.out.println("Введите индекс с которого начать поиск:");
        int index = Integer.parseInt(src.nextLine());
        System.out.println("Введите искомую подстроку:");
        String subLine = src.nextLine();
        if (stringHelper.find(index, subLine).equals("0")) {
            System.out.println("Введена пустая строка");
        } else {
            System.out.println(stringHelper.find(index, subLine));
        }
        try {
            if (stringHelper.getFirstNumber().equals("RE")) {
                throw new RuntimeException("Невозможно найти число в строке");
            } else {
                System.out.println(stringHelper.getFirstNumber() + " - первое число в строке");
            }
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
}
