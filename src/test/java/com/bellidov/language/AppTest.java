package com.bellidov.language;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void fakeTest(){
        String filePath = getClass().getClassLoader().getResource("input.txt").getPath();
        VowelStatisticsService service = new VowelStatisticsService();
        
        service.getVowelStatistics(filePath);
    }
}
