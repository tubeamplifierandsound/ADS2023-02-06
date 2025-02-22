package by.it.group251005.kurilovich.lesson01;

import java.math.BigInteger;
import java.util.ArrayList;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        BigInteger[] MyArr = new BigInteger[n + 1];
        MyArr[0] = BigInteger.ZERO;
        MyArr[1] = BigInteger.ONE;
        MyArr[2] = BigInteger.ONE;
        for (int i = 3;i < n + 1;i++)
        {
            MyArr[i] = MyArr[i - 1].add(MyArr[i - 2]);
        }
        return MyArr[n];
    }

}

