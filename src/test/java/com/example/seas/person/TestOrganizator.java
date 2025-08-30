package com.example.seas.person;


import com.example.seas.common.LocalDateBuilder;
import com.example.seas.common.entity.Person;
import com.example.seas.person.entity.Organizator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestOrganizator {

    @Test
    public void testCreateOrganizator() {
        Person organizator = new Organizator(null,"sophie","lin","1234","sophie",
                "1234","0534534","esophie@gmail.com",
                LocalDateBuilder.generateDefaultLocalDate(), 10,false,null);
        Assert.assertNotNull(organizator);
        Assert.assertEquals("Emre", organizator.getName());
    }


}
