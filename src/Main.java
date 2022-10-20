import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Список операций:" +
                "\n\t1. Добавить в список покупок;" +
                "\n\t2. Просмотреть список покупок;" +
                "\n\t3. Удалить из списка покупок." +
                "\n\t4. Поиск." +
                "\n\t5. Закончить.");

        while (true) {
            System.out.println("Выберите операцию:");
            String choice = scanner.nextLine();
            if (choice.equals("5")) {
                System.out.println("Работа завершена.");
                productList(list);
                break;
            }
            switch (choice) {
                case "1":
                    System.out.println("Какой товар вы хотите добавить");
                    String product = scanner.nextLine();
                    list.add(product);
                    System.out.println("Итого в списке покупок " + list.size() + " позиций");
                    break;
                case "2":
                case "3":
                    productList(list);
                    if (choice.equals("3")) {
                        System.out.println("Какой продукт вы хотите удалить. Введите номер или название");
                        String removeItem = scanner.nextLine();
                        if (isNumeric(removeItem)) {
                            System.out.println(list.get(Integer.parseInt(removeItem)) + " удален из списка");
                            list.remove(Integer.parseInt(removeItem));
                        } else {
                            list.remove(removeItem);
                            System.out.println(removeItem + " удален из списка");
                        }
                        productList(list);
                    }
                    break;
                case "4":
                    System.out.println("Введите текст для поиска:");
                    String lookingItem = scanner.nextLine();
                    google(list, lookingItem);
                    break;
                default:
                    System.out.println("Неверный ввод команды!");
            }
        }
    }

    public static boolean isNumeric(String removeItem) {
        try {
            Integer.parseInt(removeItem);
            return true;
        } catch (Exception E) {
            return false;
        }
    }

    public static void productList(ArrayList<String> list) {
        System.out.println("Список покупок:");
        int count = 1;
        for (String s : list) {
            System.out.println((count++) + ". " + s);
        }
    }

    public static void google(ArrayList<String> list, String lookingItem) {
        lookingItem = lookingItem.toLowerCase();
        int count = 1;
        for (String s : list) {
            String itemLower = s.toLowerCase();
            if (itemLower.contains(lookingItem)) {
                System.out.println((count) + ". " + s);
            }
            count++;
        }
    }
}

