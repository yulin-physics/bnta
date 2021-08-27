package com.yulin.bnta.person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public float aveAge(Person[] people, Gender gender){
        int sum = 0;
        List<Person> filtered = new ArrayList();
        for (Person i: people){

            if (i.getGender().equals(gender)){
                filtered.add(i);
                sum += i.getAge();
            }
        }
// If people argument is a List
//        people.forEach(p -> {
//            if (p.getGender().equals(gender)) {
//                filtered.add(p);
//                sum += p.getAge();
//            }
//        });

        int count = filtered.size();
        float result = sum/count;
        System.out.println("The average of all the "+gender+ " is "+ result+
                "\n"+ filtered);
        return result;
    }
}
