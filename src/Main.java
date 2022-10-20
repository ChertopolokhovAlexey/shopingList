import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Список операций:" +
                "\n\t" + "1. Добавить в список покупок;" +
                "\n\t" + "2. Просмотреть список покупок;" +
                "\n\t" + "3. Удалить из списка покупок.");

        while (true) {
            System.out.println("Выберите операцию:");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Какой товар вы хотите добавить");
                    String product = scanner.nextLine();
                    list.add(product);
                    System.out.println("Итого в списке покупок " + list.size() + " позиций");
                    break;
                case "2":
                case "3":
                    System.out.println("Список покупок:");
                    int i = 1;
                    for (String s : list) {
                        System.out.println((i++) + s);
                    }
                    if (choice.equals("3")) {
                        System.out.println("Какой продукт вы хотите удалить. Введите номер или название");
                        String removeItem = scanner.nextLine();
                        if (isNumeric(removeItem)) {
                            list.remove(Integer.parseInt(removeItem));
                        }else {
                            list.remove(removeItem);
                        }
                        System.out.println(list);

                    }

                    break;
                default:
                    System.out.println("");
            }
        }
    }
    public static boolean isNumeric(String removeItem) {
        System.out.println("i'm here");
        try {
            Integer.parseInt(removeItem);
            return true;
        } catch (Exception E) {
            return false;
        }
    }
}

