package com.yulin.bnta.person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        Person maria = new Person("Maria", Gender.FEMALE, 78);
        Person jack = new Person("Jack", Gender.MALE, 13);
        Person lily = new Person("lily", Gender.FEMALE, 22);

        Person[] people = {maria, jack, lily};
        PersonService personService = new PersonService();
        personService.aveAge(people, Gender.FEMALE);
    }


}
