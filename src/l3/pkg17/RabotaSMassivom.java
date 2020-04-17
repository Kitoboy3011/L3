package l3.pkg17;
import java.io.*;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.OutputStream;

public class RabotaSMassivom {

    private int size, min,k=0,k1=0, l, n0 = 1,n1 = 1,n2;
    private int[] mass;
    private String z;

    public RabotaSMassivom(int[] massiv) {
        mass = massiv;
    }

    public RabotaSMassivom(int size1) {
        size = size1;
    }
    
    public RabotaSMassivom(String z1) {
        z = z1;
    }

    public int[] getMassiv() {
        int[] mass = new int[size];
        return mass;
    }

    public int[] massivNat() {
        mass = getMassiv();
        Scanner in = new Scanner (System.in);
        System.out.println ("Введите массив: ");
        for (int m = 0; m < size; m++) {
            mass[m] = in.nextInt(); 
        }
        return mass;
    }

    public String massivVivod(int[] mass) {
        String massString = Arrays.toString(mass);
        System.out.println(massString);
        return massString;
    }

    public int[] randomMassiv() {
        mass = getMassiv();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            mass[i] = r.nextInt(100);
        }
        return mass;
    }
    
    public int poryadok(int[] mass){
        for (int i=0; i<size - 1; i++) {
            if (mass[i] < mass[i + 1]){
                k=k+1;} 
            
		else if (mass[i] > mass[i + 1]){
                    k1=k1+1;} 
                
                    else if (mass[i] == mass[i + 1]){
                        k1++;
                        k++;}
		}
   		if (k==size-1) {
                    z = "Массив упорядочен по возрастанию";
                    System.out.println(z);
                    savePoryadok(z, mass, size);} 

                    else if (k1==size-1){
                        z = "Массив упорядочен по убыванию";
                        System.out.println(z);
                        savePoryadok(z, mass, size);} 

			else {	
                            z = "Массив не упорядочен";
                            System.out.println(z);
                            savePoryadok(z, mass, size);}
                return size;
   } 
   public int minimal(int[] mass) throws IOException{
                min = mass[0];
            for(int x: mass) {
                if(x < min){
                    min = x;}        
            }
            System.out.print("Минимальный элемент: ");
            z = "Минимальный элемент: ";
            System.out.println(min); 
            l = min;
            saveZnach(min,z,size,mass);
            return min;
    }
    public int ryad(){
        System.out.println("Ряд Фибоначчи: ");
	System.out.println(n0+" ");
	System.out.println(n1+" ");
        int[] massiv = new int[11];
        massiv[0] += n0;
        massiv[1] += n1;
	for(int i = 3; i < 11; i++){
            n2=n0+n1;
            if(n2%2==0){
                System.out.println(n2+"+");}
            else{
                System.out.println(n2+" ");}
            massiv[i-1] += n2;
            n0=n1;
            n1=n2;
        }
            System.out.println();
            saveMassiv(massiv, size = 10);
        return 0;
    }
    public int ryad(int size){
        System.out.println("Ряд Фибоначчи: ");
	System.out.println(n0+" ");
	System.out.println(n1+" ");
        int[] massiv = new int[size];
        massiv[0] += n0;
        massiv[1] += n1;
	for(int i = 3; i <= size; i++){
            n2=n0+n1;
            if(n2%2==0){
                System.out.println(n2+"+");}
            else{
                System.out.println(n2+" ");}
            massiv[i-1] += n2;
            n0=n1;
            n1=n2;
        }
            System.out.println();
            saveMassiv(massiv, size);
        return 0;
    }
        
    public static void saveZnach(int min, String z, int size, int[] mass) throws IOException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Сохранить в файл?");
        System.out.println("Да-1 | Нет-2");
        int vibor = scan.nextInt();
        
        switch (vibor) {
            case 0:
                break;
            case 1:
                System.out.println("Введите название файла");
                String fileName = scan.next();
                File myFile = new File (fileName+".txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFile)))
                {
                    for (int i = 0;i < size;i++)
                    {
                        writer.write(mass[i] + " ");
                    }
                    writer.write("\n");
                    writer.write(z);
                    writer.write(String.valueOf(min));
                    writer.flush();
                    writer.close();
                } 
                catch (IOException ex) {
                   System.out.println(ex.getMessage());
                }
                
                break;
            case 2:
                System.out.println("Результат не был сохранен");
                break;
            default:
                System.out.println("Ошибка выбора");
                break;
        }
    }
    
        public static void savePoryadok(String z, int[] mass,int size) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Сохранить в файл?");
        System.out.println("Да-1 | Нет-2");
        int vibor = scan.nextInt();
        
        switch (vibor) {
            case 0:
                break;
            case 1:
                System.out.println("Введите название файла");
                String fileName = scan.next();
                File myFile = new File (fileName+".txt");
                try(BufferedWriter writer = new BufferedWriter (new FileWriter(myFile)))
                {
                    for(int i = 0;i < size;i++)
                    {
                        writer.write(mass[i] + " ");
                    }
                    writer.write("\n");
                    writer.write(z);
                    writer.flush();
                    writer.close();                   
                } 
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:
                System.out.println("Результат не был сохранен");
                break;
            default:
                System.out.println("Ошибка выбора");
                break;
        }
    }
    
    public static void saveMassiv(int[] massiv, int size) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Сохранить в файл?");
        System.out.println("Да-1 | Нет-2");
        int vibor = scan.nextInt();
        
        switch (vibor) {
            case 0:
                break;
            case 1:
                System.out.println("Введите название файла");
                String fileName = scan.next();
                File myFile = new File (fileName+".txt");
                try (BufferedWriter writer = new BufferedWriter (new FileWriter(myFile))) {
                    for (int i = 0; i<size; i++)
                    {                    
                        if(massiv[i]%2==0)
                        {
                            writer.write(massiv[i]+"+");
                            writer.write("\n");
                        }
                        else
                        {
                            writer.write(massiv[i]+" ");
                            writer.write("\n");
                        }
                    }
                    writer.flush();
                    writer.close();
                } 
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 2:
                System.out.println("Результат не был сохранен");
                break;
            default:
                System.out.println("Ошибка выбора");
                break;
        }
    }
    
    public int[] readFile() {
        mass = getMassiv();
        int[] ma = new int[size];
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите название файла с расширением .txt:");
        String fileName = scan.next();
        try(FileInputStream file = new FileInputStream(fileName))
        {
            Scanner scane= new Scanner(file);
            for(int i=0; i<size ;i++){
            ma[i] = scane.nextInt();
            mass[i] = ma[i];
            }
        }
        catch(IOException ex )
        {
            ex.printStackTrace();
        }
        return mass;
    }
}
