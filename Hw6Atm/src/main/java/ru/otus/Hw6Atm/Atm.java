package ru.otus.Hw6Atm;

import java.util.ArrayList;

public class Atm {
    private Cassete cas = new Cassete();

    private void moneySort(Nominal banknote) {
        if (banknote.equals(Nominal.TEN)) {
            cas.casTen.add(banknote);
        } else if (banknote.equals(Nominal.FIFTY)) {
            cas.casFift.add(banknote);
        } else if (banknote.equals(Nominal.HUNDRED)) {
            cas.casHundr.add(banknote);
        } else if (banknote.equals(Nominal.FIVE_HUNDRED)) {
            cas.casFiveHundr.add(banknote);
        } else if (banknote.equals(Nominal.THOUSAND)) {
            cas.casThous.add(banknote);
        } else {
            throw new RuntimeException("Неизвестный номинал");
        }
    }

    private int moneyGet(int sum, int banknoteValue, ArrayList casType) {
        if (sum / banknoteValue >= 1) {
            if (casType.size() >= sum / banknoteValue) {
                int count = sum / banknoteValue;
                for (int i = 0; i < count; i++) {
                    casType.remove(casType.size() - 1);
                }
                sum = sum - banknoteValue * count;
                System.out.println("Возможно снять: " + banknoteValue * count);
            } else {
                System.out.println("Не хватает купюр номиналом: " + banknoteValue);
            }
        }
        return sum;
    }

}
