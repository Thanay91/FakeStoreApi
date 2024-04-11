package org.scaler.fakestor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RandomTests {
    @Test
    public void obePlusOneISTwo(){
        //3 AAA of Testing
        //Arrange
        int a = 1;
        int b = 1;

        //Act
        int x = a+b;

        //Assert
        Assertions.assertEquals(2, x);

    }
}
