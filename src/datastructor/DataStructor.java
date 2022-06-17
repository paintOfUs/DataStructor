/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datastructor;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class DataStructor {

    public static float[] numbers;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("+-------------Menu--------------+");
            System.out.println("|   1.Input                     |");
            System.out.println("|   2.Output                    |");
            System.out.println("|   3.Buble sort                |");
            System.out.println("|   4.Selection sort            |");
            System.out.println("|   5.Insertion sort            |");
            System.out.println("|   6.Search > value            |");
            System.out.println("|   7.Search = value            |");
            System.out.println("|   0.Exit                      |");
            System.out.println("+-------------------------------+");

            System.out.print("Nhap So: ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Ban chon so 1");
                    getInput();
                    break;
                case 2:
                    System.out.println("Ban chon so 2");
                    takeOutput();
                    break;
                case 3:
                    System.out.println("Ban chon so 3");
                    bubleSort(numbers);
                    break;
                case 4:
                    System.out.println("Ban chon so 4");
                    selectionSort(numbers);
                    break;
                case 5:
                    System.out.println("Ban chon so 5");
                    insSort(numbers);
                    break;
                case 6:
                    System.out.println("Ban chon so 6");
                    linearSearch(numbers);
                    break;
                case 7:
                    System.out.println("Ban chon so 7");
                    binarySearch(numbers);
                    break;
                case 0:
                    System.out.println("Ban chon so 0");
                    System.exit(0);
                    break;
            }
        }
    }

    /*In put
    * B1: set length of Array
    * B2: set each element of Array
    * B3: write in the file
     */
    public static void getInput() throws IOException {
        Scanner sc = new Scanner(System.in);
        FileWriter f = new FileWriter("input.txt");

        System.out.println("So phan tu mang muon khoi tạo(n < 20)");
        System.out.print("Nhap n : ");
        int n = sc.nextInt();
        int i = 0;
        while (i < n) {
            System.out.printf("nhap phan tu thu %d: \n", (i + 1));
            float element = sc.nextFloat();
            sc.nextLine();

            f.write(element + " ");
            i++;
        }
        f.close();

    }

    /*Output
    * B1: read file
    * B2:  get data
    * B3: set data
     */
    public static void takeOutput() throws FileNotFoundException, IOException {
        FileReader f = new FileReader("input.txt");

        BufferedReader bReader = new BufferedReader(f);

        String line;
        String s1 = "";
        String[] lines;
        int i = 0;

        while ((line = bReader.readLine()) != null) {
            s1 += line;
        }

        //split String and assign array lines
        lines = s1.split("\\s");
        numbers = new float[lines.length];
        float number;

        //change each element of  Array lines to float and assign of number
        for (String x : lines) {
            number = Float.parseFloat(x);
            numbers[i] = number;
            i++;
        }

        //display array
        /*System.out.print("[");
        *for (float x : numbers) {
        *    System.out.print(x + " ");
        *}
        *System.out.print("]");
         */
        System.out.println(Arrays.toString(numbers));

        bReader.close();
    }

    /*Buble sort
    * copy array numbers to buble
    * start buble sort and print array to console
     */
    public static void bubleSort(float[] nums) throws IOException {
        FileWriter f = new FileWriter("input1.txt");
        float[] buble = new float[nums.length];

        for (int i = 0; i < nums.length; i++) {
            buble[i] = nums[i];
        }

        for (int i = 0; i < buble.length - 1; i++) {
            for (int j = 0; j < (buble.length) - 1 - i; j++) {
                if (buble[j] > buble[j + 1]) {
                    float temp = buble[j];
                    buble[j] = buble[j + 1];
                    buble[j + 1] = temp;
                }

            }
            for (float x : buble) {
                System.out.print(x + " ");
                f.write(x + " ");
            }
            f.write("\n");
            System.out.println("");
        }
        f.close();
    }

    public static void selectionSort(float[] nums) throws IOException {
        FileWriter f = new FileWriter("input2.txt");
        float[] selSort = new float[nums.length];

        for (int i = 0; i < nums.length; i++) {
            selSort[i] = nums[i];
        }

        for (int i = 0; i < selSort.length - 1; i++) {
            //moi vong lap tang min len va su dung lam index
            int min = i;

            //kiem tra gia tri min nam o dau trong mang va gan vao bien min
            for (int j = i + 1; j < selSort.length; j++) {
                if (selSort[min] > selSort[j]) {
                    min = j;
                }
            }

            //khi bien min thay doi tuc co vi tri min moi tha thuc hien doi cho
            if (min != i) {
                float temp = selSort[i];
                selSort[i] = selSort[min];
                selSort[min] = temp;
            }

            for (float x : selSort) {
                System.out.print(x + " ");
                f.write(x + " ");
            }
            f.write("\n");
            System.out.println("");
        }
        f.close();
    }

    public static void insSort(float[] nums) throws IOException {
        FileWriter f = new FileWriter("input3.txt");
        float[] insSort = new float[nums.length];

        for (int i = 0; i < nums.length; i++) {
            insSort[i] = nums[i];
        }

        // bat dau cho index thu hai vao bien temp luu tam de thuc hien doi cho
        for (int i = 1; i < insSort.length; ++i) {
            float temp = insSort[i];
            int j = i - 1;

            // kiem tra index dang truoc co lon hon ko thi thuc hien doi cho
            while (j >= 0 && insSort[j] > temp) {
                insSort[j + 1] = insSort[j];
                j = j - 1;
            }

            insSort[j + 1] = temp;

            for (float x : insSort) {
                System.out.print(x + " ");
                f.write(x + " ");
            }
            f.write("\n");
            System.out.println("");

        }
        f.close();
    }

    public static int linearSearch(float[] nums) throws IOException {
        FileWriter f = new FileWriter("input4.txt");

        float[] search = new float[nums.length];
        System.arraycopy(nums, 0, search, 0, nums.length);
        //System.out.println(Arrays.toString(search));

        Scanner sc = new Scanner(System.in);
        System.out.print("Input value: ");
        float read = sc.nextFloat();
        sc.nextLine();

        //tim kiem read trong mang tim ra thi tra ve vi tri cua no, neu khong co thi tra ve -1
        //nhuoc diem can phai duyet het mang
        for (int i = 0; i < search.length; i++) {
            if (search[i] == read) {

                System.out.println("index: " + i);
                f.write("index search is : "+i);
                f.close();
                return i;
            }
        }
        System.out.println("out index: " + -1);
        f.write("index search is out: "+ - 1);
        f.close();
        return -1;
    }

    public static int binarySearch(float[] nums) throws IOException {
        FileWriter f = new FileWriter("input5.txt");

        float[] binary = new float[nums.length];
        System.arraycopy(nums, 0, binary, 0, nums.length);

        int l = 0;
        int r = binary.length - 1;

        Scanner sc = new Scanner(System.in);
        System.out.print("Input value: ");
        float read = sc.nextFloat();
        sc.nextLine();

        while (l <= r) {
            //chia mang thanh 3 phan trai , phai va giua 
            int m = (l + r) / 2;

            //neu gia tri can tim o giua thi in ra
            if (binary[m] == read) {
                System.out.println("index value: " + m);
                f.write("index search is: "+m);
                f.close();
                return m;
            }

            /*neu gia tri can tim lon hon vi tri giua thi index no nam ben phai
            nguoc lai indẽ nam ben trai*/
            if (binary[m] < read) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println("out of index: " + -1);
        f.write("index search is out: "+-1);
        f.close();
        return -1;
    }
}
