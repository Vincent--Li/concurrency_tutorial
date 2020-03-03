package com.vincent.concurrency.chapter2;

/**
 * Title:  concurrency_tutorial
 * Description TODO
 * Company: https://www.zhishinet.com
 *
 * @Author Vincent Li
 * @Date 2020/3/3 9:36
 */
public class TaxCalculatorMain {

    public static void main(String[] args) {
//        TaxCalculator calculator = new TaxCalculator(10000d, 2000d){
//            @Override
//            public double calcuate() {
//                return getSalary() * 0.1 + getBnous() * 0.15;
//            }
//        };
//
//        double tax = calculator.calcuate();
//        System.out.println(tax);
        TaxCalculator calculator = new TaxCalculator(10000d, 2000d);

        CalculatorStrategy strategy = new SimpleCalculatorStragety();
        calculator.setCalculatorStrategy(strategy);
        System.out.print(calculator.calcuate());
    }
}
