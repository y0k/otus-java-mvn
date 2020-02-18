package ru.otus.hw02;

public class Main {

    public static void main(String[] args) {


        DIYarrayList<Integer> diYarrayList = new DIYarrayList<>();

        /*заполнение элементами >20*/
        for (int i = 1; i<=25; i++) {
            diYarrayList.add(i);
        }

        DIYarrayList<Integer> diYarrayList_1 = new DIYarrayList<>();

        diYarrayList_1.add(11);
        diYarrayList_1.add(22);
        diYarrayList_1.add(12);
        diYarrayList_1.add(14);

        diYarrayList_1.addAll(diYarrayList);

        diYarrayList<Integer> diYarrayList_2 = new DIYarrayList<Object>(diYarrayList_1.size());

        /*1*//*
        Collections.addAll(diYarrayList, 1,25);
        System.out.println("Collections.addAll: "+diYarrayList);

        *//*2*//*
        Collections.copy(diYarrayList_1, diYarrayList);
        System.out.println("Collections.copy: "+diYarrayList_1);

        *//*3*//*
        Collections.sort(diYarrayList_1, Comparator.naturalOrder());
        System.out.println("Collections.sort: "+diYarrayList_1);*/
    }
}
