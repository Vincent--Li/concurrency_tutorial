package com.vincent.concurrency.chapter2;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:50
 */

public class SimpleCalculatorStragety implements CalculatorStrategy {

    private final static double SALARY_RATE = 0.1;

    private final static double BONUS_RATE = 0.1;

    @Override
    public double calculate(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
