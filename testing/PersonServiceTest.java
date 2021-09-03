package com.yulin.bnta.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

class PersonServiceTest {

    @Mock
    private PersonDAO personDAO;
    private PersonService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new PersonService(personDAO);
    }


    @Test
    void isNull_itShouldThrow() {
        //Given
        Person person = new Person(0, null, 0);

        //When
        assertThatThrownBy(() -> {
            underTest.savePerson(person);
        })
            .hasMessage("Person cannot have empty fields")
            .isInstanceOf(IllegalStateException.class);

        //Then
        Mockito.verifyNoInteractions(personDAO);
    }

    @Test
    void isPerson_itShouldSave() {
        //Given
        Person person = new Person(0, "name", 0);

        //When
        int savePerson = underTest.savePerson(person);
        System.out.println(savePerson);
        //Then
        Mockito.atLeastOnce();
        verify(personDAO).savePerson(person);

    }

    @Test
    void isPersonAndExists_itShouldThrow() {
        //Given
        Person person = new Person(0, "name", 0);
        Mockito.when(personDAO.getPeople()).thenReturn(List.of(person));

        //When
        assertThatThrownBy(() -> {
            underTest.savePerson(person);
        })
                .hasMessage("person with id " + person.getId() + " already exists")
                .isInstanceOf(IllegalStateException.class);

        //Then
        Mockito.atMostOnce();
    }


    @Test
    void isPersonAndExists_itCanDeletePerson() {
        //Given
        Person person = new Person(0, "name", 0);
        Mockito.when(personDAO.getPeople()).thenReturn(List.of(person));

        //When
        underTest.deletePerson(person.getId());

        //Then
        Mockito.verify(personDAO).deletePerson(person.getId());

    }

    @Test
    void isPersonAndNotExist_itShouldThrow() {
        //Given
        Person person = new Person(0, "name", 0);

        //When
        assertThatThrownBy(() -> {
            underTest.deletePerson(person.getId());
        })
            .hasMessage("person with id " + person.getId() + " not found")
            .isInstanceOf(IllegalStateException.class);

        //Then
        Mockito.atMostOnce();

    }

    @Test
    void canGetPeopleFromDB() {
        //Given
        List<Person> people = List.of(new Person(0,"name", 0));
        Mockito.when(personDAO.getPeople()).thenReturn(people);
        //When
        List<Person> actual = underTest.getPeople();
        //Then
        assertThat(actual).isEqualTo(people);

    }

    @Test
    void canGetPersonById() {
        //Given
        List<Person> people = List.of(new Person(0,"name", 0));
        Mockito.when(personDAO.getPeople()).thenReturn(people);
        //When
        Optional<Person> actual = underTest.getPersonById(0);
        Optional<Person> expected = Optional.of(new Person(0,"name", 0));
        //Then
        assertThat(actual).isEqualTo(expected);

    }


}