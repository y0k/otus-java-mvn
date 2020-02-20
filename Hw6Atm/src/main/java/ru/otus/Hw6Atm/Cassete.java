package ru.otus.Hw6Atm;

import java.util.EnumMap;
import java.util.EnumSet;

public class Cassete {

    public enum Nominal {
        TEN(10),
        FIFTY(50),
        HUNDRED(100),
        FIVE_HUNDRED(500),
        THOUSAND(1000);

        private final Integer label;

        Nominal(int label) {
            this.label = label;
        }

        public static Nominal getEnumByInt(int value) {
            for (Nominal e : Nominal.values()) {
                if (value == e.getLabel()) return e;
            }
            return null;
        }

        public int getLabel() {
            return label;
        }
    }

    public final EnumMap casmap;

    public int nominalscount;

    public Cassete(int nominalscount) {
        this.casmap = createCas(nominalscount);
        this.nominalscount = nominalscount;
    }

    private EnumMap createCas(int nominalscount) {
        EnumMap<Nominal, Integer> casmap = new EnumMap<>(Nominal.class);
        EnumSet.allOf(Nominal.class).forEach(nominal -> casmap.put(nominal, nominalscount));
        return casmap;
    }
}
