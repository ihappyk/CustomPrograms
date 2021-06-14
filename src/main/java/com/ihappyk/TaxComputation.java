package com.ihappyk;

import java.util.ArrayList;
import java.util.List;

public class TaxComputation
{
    static class TaxBracket {
        Integer limit;
        double tax;

        public TaxBracket (Integer limit, double tax)
        {
            this.limit = limit;
            this.tax = tax;
        }
    }

    private static void calculateTax (Integer income, List<TaxBracket> taxBracketList) {
        double tax = 0.0;
        int earning = income;
        int index = 0;
        while(income > 0 ) {
            TaxBracket bracket =  taxBracketList.get(index);
            if(bracket.limit != null ) {
                int amount = Math.min(bracket.limit, income);
                tax = tax + (amount * bracket.tax);
                income = income - amount;
            }
            else {
                tax = tax + (income * bracket.tax);
                break;
            }
            ++index;
        }
        System.out.println("Calculated Taxes: " + tax +  " for income: " +  earning);
    }
    public static void main(String[] args) {
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(10000, 0.1));
        taxBrackets.add(new TaxBracket(20000, 0.2));
        taxBrackets.add(new TaxBracket(15000, 0.3));
        taxBrackets.add(new TaxBracket(null, 0.5));
        int income = 100000;
        calculateTax(income, taxBrackets);
    }
}
