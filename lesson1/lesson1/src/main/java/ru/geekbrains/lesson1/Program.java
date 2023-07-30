package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Program {

    public static void main(String[] args) {


        //int a = 7 % 9;
       // int b = 9 % 7;

        int lastNumber = 43;
        AtomicInteger counter = new AtomicInteger();

        StringBuilder stringBuilder1 = new StringBuilder("AAA");
        System.out.printf("Сумма всех чисел от 1 до %d равна %d\n", lastNumber, sum(lastNumber, counter, stringBuilder1));
        System.out.println("Кол-во итераций: " + counter.get());
        //System.out.println(stringBuilder1.toString());

        System.out.printf("Сумма всех чисел от 1 до %d равна %d\n", lastNumber, sum2(lastNumber));


        counter.set(0);
        System.out.println("Простые числа: " + findFimpleNumbers(lastNumber, counter));
        System.out.println("Кол-во итераций: " + counter.get());

        counter.set(0);
        long startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для индекса %d равно %d (РЕКУРСИЯ)\n", lastNumber, fb1(lastNumber, counter));
        long endTime = System.currentTimeMillis();
        System.out.println("Кол-во итераций: " + counter.get());
        System.out.printf("Операция выполнена за %d мс.\n", endTime - startTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для индекса %d равно %d\n", lastNumber, fb2(lastNumber, counter));
        endTime = System.currentTimeMillis();
        System.out.println("Кол-во итераций: " + counter.get());
        System.out.printf("Операция выполнена за %d мс.\n", endTime - startTime);

        f(4);
    }

    /**
     * [1] Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
     * @return
     */
    public static int sum(int lastNumber, AtomicInteger c, StringBuilder sb){
        int sum = 0;
        for (int i = 1; i <= lastNumber; i++){
            sum += i; // sum = sum + i;
            c.getAndIncrement(); // +1
            sb.append(i);
        }
        return sum;
    }

    public static int sum2(int lastNumber){
        return ((1 + lastNumber) * lastNumber) / 2;
    }

    /**
     * [2] Написать алгоритм поиска простых чисел (делятся только на себя и на 1)
     *
     *  1 2 3 4 5 6
     *
     */
    public static ArrayList<Integer> findFimpleNumbers(int lastNumber, AtomicInteger counter){
        ArrayList<Integer> simpleNumbers = new ArrayList<>();
        for (int i = 1; i <= lastNumber; i++){
            boolean isSimple = true;
            for (int j = 2; j < i; j++){
                counter.getAndIncrement();
                if (i % j == 0){
                    isSimple = false;
                    break;
                }
            }
            if (isSimple)
                simpleNumbers.add(i);
        }
        return  simpleNumbers;
    }

    /**
     * n = 4
     * @param n
     */
    static void f(int n){
        System.out.println(n);
        if (n >= 3){
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }

    /**
     * Разработать алгоритм поиска нужного числа последовательности Фибоначчи
     *
     * 0 1 2 3 4 5 6  7  8  9 10
     *
     * 0 1 1 2 3 5 8 13 21 34 55 ...
     *
     * @param num
     * @return
     */
    public static long fb1(int num, AtomicInteger counter){
        counter.getAndIncrement();
        if (num == 0 || num == 1)
            return num;
        return fb1(num - 1, counter) + fb1(num - 2, counter);
    }

    public static long fb2(int num, AtomicInteger counter){
        if (num == 0 || num == 1)
            return num;
        int[] array = new int[num + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i ++){
            counter.getAndIncrement();
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[num];
    }


}
