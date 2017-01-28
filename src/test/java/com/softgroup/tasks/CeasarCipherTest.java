package com.softgroup.tasks;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CeasarCipherTest {
    @Test
    public void encrypt() throws Exception {
        String actualResult = CeasarCipher.encrypt("First Legion", 23);
        String expectedResult = "Cfopq Ibdflk";
        Assert.assertEquals(expectedResult, actualResult);

        actualResult = CeasarCipher.encrypt("First Legion", 17);
        expectedResult = "Wzijk Cvxzfe";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void encryptTwoKeys() throws Exception {
        String actualResult = CeasarCipher.encryptTwoKeys("First Legion", 23, 17);
        String expectedResult = "Czojq Ivdzle";
        Assert.assertEquals(expectedResult, actualResult);
    }

}