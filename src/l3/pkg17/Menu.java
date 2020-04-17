package l3.pkg17;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private static int size, l = 0;
    private static int[] mass;
    private String z = "Пусто";

    public Menu(int size1, int[] mass1) {
        size = size1;
        mass = mass1;
    }

    public static int[] poryadokMinimal() throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        size = scan.nextInt();
        System.out.println("Выберите режим заполнения массива");
        System.out.println ("1 - Рандомные числа. ");
        System.out.println ("2 - Заполнить самому. ");
        System.out.println ("3 - Считать из файла. ");
        System.out.println ("0 - Выйти в главное меню. ");
        int vibor = scan.nextInt();

        RabotaSMassivom ourMassiv = new RabotaSMassivom(size);
        int[] massiv = ourMassiv.getMassiv();
        switch (vibor) {
            case 0:

                break;
            case 1:
                massiv = ourMassiv.randomMassiv();
                vivod(massiv);
                break;
            case 2:
                massiv = ourMassiv.massivNat();
                vivod(massiv);
                break;
            case 3:
                massiv = ourMassiv.readFile();
                vivod(massiv);
                break;
            default:
                System.out.println("Ошибка выбора");
                break;
        }
        return massiv;

    }

    
    public static void reshenie(int[] massiv) throws IOException {
        System.out.println("Выберите режим вывода массива");
        System.out.println ("1 - Определить упорядоченность массива. ");
        System.out.println ("2 - Найти минимальный элемент массива. ");
        System.out.println ("0 - Выйти в главное меню. ");
        RabotaSMassivom ourMassiv = new RabotaSMassivom(size);
        Scanner scan = new Scanner(System.in);
        int vibor = scan.nextInt();

        switch (vibor) {
            case 0:
                break;
            case 1:
                ourMassiv.poryadok(massiv);
                break;
            case 2:
                ourMassiv.minimal(massiv);
                break;
            default:
                System.out.println("Ошибка выбора");
                break;
        }
    }

    public static void Ryad() {
        Scanner scan = new Scanner(System.in);
        System.out.println ("1 - Задать размер вручную. ");
        System.out.println ("2 - Размер по заданию. ");
        System.out.println ("0 - Выйти в главное меню. ");
        RabotaSMassivom ourMassiv = new RabotaSMassivom(size);
        int vibor = scan.nextInt();

        switch (vibor) {
            case 0:
                System.out.println("Массив не выведен на экран");
                break;
            case 1:
                System.out.println("Введите размер массива: ");
                size = scan.nextInt();
                ourMassiv.ryad(size);
                break;
            case 2:
                ourMassiv.ryad();
                break;
            default:
                System.out.println("Ошибка выбора");
                break;
        }
    }
    
    public static void vivod(int[] massiv) throws IOException {
        System.out.println("Выберите режим вывода массива");
        System.out.println ("1 - Вывести массив. ");
        System.out.println ("2 - Не выводить массив массив. ");
        System.out.println ("0 - Выйти в главное меню. ");
        RabotaSMassivom ourMassiv = new RabotaSMassivom(size);
        Scanner scan = new Scanner(System.in);
        int vibor = scan.nextInt();

        switch (vibor) {
            case 0:
                System.out.println("Массив не выведен на экран");
                break;
            case 1:
                ourMassiv.massivVivod(massiv);
                reshenie(massiv);
                break;
            case 2:
                reshenie(massiv);
                break;
            default:
                System.out.println("Ошибка выбора");
                break;
        }
    }
}
