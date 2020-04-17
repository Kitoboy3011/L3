package l3.pkg17;
import java.io.IOException;
import java.util.Scanner;

public class L317 {

    public static void main(String[] args) throws IOException {
        int vibor;
        do {
            Scanner scan = new Scanner(System.in);

            System.out.println("Главное меню");
            System.out.println ("1 - Найти упорядоченность массива и минимальное число в массиве. ");
            System.out.println ("2 - Создать ряд Фибоначчи. ");
            System.out.println ("0 - Выйти из программы. ");
            vibor = scan.nextInt();

            switch (vibor) {
                case 0:
                    System.exit(vibor);
                    break;
                case 1:
                    Menu.poryadokMinimal();
                    break;
                case 2:
                    Menu.Ryad();
                    break;
                default:
                    System.out.println("Ошибка выбора");
                    break;
            }
        } while (vibor != 0);
    }
}
