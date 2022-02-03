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
        personList.addPersons(100);
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
    private List<Person> persons = new ArrayList<>();

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    public void addPersons(int number) {

        for (int i = 0; i < number; i++) {
            String firstName = FIRST_NAME[RANDOM.nextInt(FIRST_NAME.length)];
            String lastName = LAST_NAME[RANDOM.nextInt(LAST_NAME.length)];
            int age = RANDOM.nextInt(46) + 20;
            int height = RANDOM.nextInt(51) + 150;
            //  The formula is BMI = kg/m2 where kg is a person's weight in kilograms and m2 is their height in metres squared.
            //  A BMI of 25.0 or more is overweight, while the healthy range is 18.5 to 24.9.
            int bmi = RANDOM.nextInt(13) + 18;
            double weight = round(Math.pow(height / 100d, 2) * bmi, 1);
            Person person = new Person(firstName, lastName, age, height, weight);
            persons.add(person);
        }
    }
}
