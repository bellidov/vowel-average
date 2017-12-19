package com.bellidov.language;


import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void getVowelStatisticsTest(){
        File file = new File(getClass().getClassLoader().getResource("input.txt").getFile());
        VowelStatisticsService service = new VowelStatisticsService();
        
        Map<VowelKey, List<VowelWordCounter>> results = service.getVowelStatistics(file.getAbsolutePath());

        assertNotNull(results);
        assertTrue(!results.isEmpty());
        assertTrue(!results.keySet().isEmpty());

        for (Map.Entry<VowelKey, List<VowelWordCounter>> entry : results.entrySet()){
            for(VowelWordCounter counter : entry.getValue()) {
                System.out.println(entry.getKey() + ", " + counter.getWordLength() + "} -> " + (double)counter.getVowelCounter() / counter.getWordCounter());
                assertNotNull(entry.getKey());
                assertNotNull(entry.getValue());
            }

        }
    }

}
