package com.mykhailo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonFactory {

    public static final Random RANDOM = new Random();
    public static final String[] FIRST_NAME = {"Jack", "James", "Noah", "Daniel", "Conor", "Finn", "Harry", "Charlie"};
    public static final String[] LAST_NAME = {"Duffy", "Brown", "Ryan", "Lynch", "Collins", "Quinn", "Walsh", "Connor"};

    public static void main(String[] args) {

        PersonFactory personList = new PersonFactory();
        personList.addPerson(100);
        System.out.println(personList.persons);

    }

    /*
    1. Создать класс Person который описывает человека, с полями: имя, фамилия, возраст, вес, рост.
    Создать один или несколько конструкторов которые гарантирует что у каждого есть имя и фамилия.
    Создать список из 100 обьектов типа Person заполненных случайными данными (Например создать массив
    на несколько имен и выбирать из него случайным образом).
    Код который создает список Person и заполняет его данными разместить в другом классе,
    не в Person, например в PersonFactory.
    Обеспечить чтобы случайные данные (вес, рост, возраст) выглядели правдоподобно:
    не было человека весом 3 кг и ростом 180 итд.
    */
    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    private List<Person> persons = new ArrayList<>();

    public void addPerson(int number) {
        Person person;
        for (int i = 0; i < number; i++) {
            persons.add(person = new Person(setFirstName(), setLastName(), setAge(), setHeight()));
            person.setWeight(round(Math.pow(person.getHeight() / 100d, 2) * setBmi(), 1));
        }
    }

    public static String setFirstName() {
        return FIRST_NAME[RANDOM.nextInt(FIRST_NAME.length)];
    }

    public static String setLastName() {
        return LAST_NAME[RANDOM.nextInt(LAST_NAME.length)];
    }

    public static int setAge() {
        return RANDOM.nextInt(46) + 20;
    }

    public static int setHeight() {
        return RANDOM.nextInt(51) + 150;
    }

    //  The formula is BMI = kg/m2 where kg is a person's weight in kilograms and m2 is their height in metres squared.
    //  A BMI of 25.0 or more is overweight, while the healthy range is 18.5 to 24.9.
    public static int setBmi() {
        return RANDOM.nextInt(13) + 18;
    }
}
