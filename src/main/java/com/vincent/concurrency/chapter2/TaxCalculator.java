package com.vincent.concurrency.chapter2;

import lombok.Data;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:35
 */
@Data
public class TaxCalculator {

    private final double salary;

    private final double bnous;

    private CalculatorStrategy calculatorStrategy;

    public TaxCalculator(double salary, double bnous) {
        this.salary = salary;
        this.bnous = bnous;
    }

    protected double calcTax(){
        return calculatorStrategy.calculate(salary, bnous);
    }

    public double calcuate(){
        return this.calcTax();
    }
}
