package ru.otus.Hw6Atm;

public class PrintAllMoney {

    public void printAllMoney(Atm atm) {
        if(totalMoney(atm) != 0) {
            System.out.println("Остаток: " + atm.cas.casmap);
        } else {
            System.out.println("Денег нет");
        }
    }

    private int totalMoney(Atm atm) {
        int totalsum = 0;
        for (Cassete.Nominal e : Cassete.Nominal.values()) {
            totalsum = totalsum + e.getLabel() * (int) atm.cas.casmap.get(e);
        }
        System.out.println("Денег: " + totalsum);
        return totalsum;
    }
}
