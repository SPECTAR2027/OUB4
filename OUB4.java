import java.util.*;
import java.util.stream.Collectors;

public class OUB4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Ключ!");
        String key = scanner.nextLine();
        System.out.println("Введите текст");
        String[] name = scanner.nextLine().split("");
        System.out.println("Выберите операцию");
        System.out.println("Кодировать - 1");
        System.out.println("Декодировать - 2");
        int operation = Integer.parseInt(scanner.nextLine());
        List<String> alphabet = new ArrayList<>();

        for (char i = 'А'; i <= 'я'; i++) {
            alphabet.add(String.valueOf(i));
        }
        alphabet.add(6, "Ё");
        alphabet.add(39, "ё");
        alphabet.add(" ");
        alphabet.add(")");
        alphabet.add("(");
        alphabet.add("{");
        alphabet.add("}");
        alphabet.add("!");
        alphabet.add("?");
        alphabet.add(",");
        alphabet.add("]");
        alphabet.add("[");
        alphabet.add(".");



        List<List<String>> list = shiftLists(alphabet);
        // list.forEach(System.out::println);
        for (int i = 0; i < key.length()-1; i++) {
            System.out.println(alphabet); // Выводим основной алфавит
            System.out.println(list.get(alphabet.indexOf(key.split("")[i]))); // Выводим  алфавит которы начинается на индекс Ключа
            System.out.println();
            System.out.println((alphabet.get(alphabet.indexOf(key.split("")[i]))) + " Индекс Ключа");
            System.out.println((alphabet.get(alphabet.indexOf(name[i])))+ " Индекс текста");
            int count = alphabet.indexOf(name[i]) - alphabet.indexOf(alphabet.get(0)); // Считаем разницу между элментом слова и 0 элментом
            System.out.println((alphabet.get(alphabet.indexOf(key.split("")[i])+count))); // Прибавляем к 0 элменту ключа разницу



        }

    }

    public static List<List<String>> shiftLists(List<String> originalList) {
        List<List<String>> resultList = new ArrayList<>();

        for (int n = 0; n < originalList.size(); n++) {
            List<String> shiftedList = new ArrayList<>(originalList.size());

            for (int i = 0; i < originalList.size(); i++) {
                int newIndex = (i + n) % originalList.size();
                shiftedList.add(originalList.get(newIndex));
            }

            resultList.add(shiftedList);
        }
        return resultList;
    }
}

