package com.dasolute.sample;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"property.value=propertyTest"}, classes = {SampleApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleApplicationTest {

    @Value("${property.value}")
    private String propertyValue;

    @Test
    public void contextLoads() {
        assertThat(propertyValue, is("propertyTest"));
    }
}