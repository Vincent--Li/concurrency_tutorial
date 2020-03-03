package com.vincent.concurrency.chapter2;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:48
 */
@FunctionalInterface
public interface CalculatorStrategy {

    double calculate(double salary, double bnous);
}
