import java.util.*;
import java.util.stream.Collectors;

public class OUB4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ����!");
        String key = scanner.nextLine();
        System.out.println("������� �����");
        String[] name = scanner.nextLine().split("");
        System.out.println("�������� ��������");
        System.out.println("���������� - 1");
        System.out.println("������������ - 2");
        int operation = Integer.parseInt(scanner.nextLine());
        List<String> alphabet = new ArrayList<>();

        for (char i = '�'; i <= '�'; i++) {
            alphabet.add(String.valueOf(i));
        }
        alphabet.add(6, "�");
        alphabet.add(39, "�");
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
            System.out.println(alphabet); // ������� �������� �������
            System.out.println(list.get(alphabet.indexOf(key.split("")[i]))); // �������  ������� ������ ���������� �� ������ �����
            System.out.println();
            System.out.println((alphabet.get(alphabet.indexOf(key.split("")[i]))) + " ������ �����");
            System.out.println((alphabet.get(alphabet.indexOf(name[i])))+ " ������ ������");
            int count = alphabet.indexOf(name[i]) - alphabet.indexOf(alphabet.get(0)); // ������� ������� ����� �������� ����� � 0 ��������
            System.out.println((alphabet.get(alphabet.indexOf(key.split("")[i])+count))); // ���������� � 0 ������� ����� �������



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

