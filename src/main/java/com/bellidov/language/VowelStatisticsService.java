package com.bellidov.language;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class VowelStatisticsService {

    private Map<VowelKey, List<VowelWordCounter>> statistics = new TreeMap<>();
    
    public Map<VowelKey, List<VowelWordCounter>> getVowelStatistics(String filePath) {
        
        
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(x -> this.handleText(x));
        } catch (IOException e) {
            System.out.println("Unable to read from the file " + filePath + " as it does not exist.");
        }
        
        return statistics;
    }
    
    private void handleText(String line) {
        String[] words = line.trim().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        
        for(String word : words) {
            VowelKey vowelKey = getVowelKey(word);
            Integer vowelCounter = vowelKey.getTotalVowelsCount();
            if(!statistics.containsKey(vowelKey)) {
                List<VowelWordCounter> wordList = new ArrayList<>();
                VowelWordCounter vowelWordCounter = new VowelWordCounter(vowelCounter, word.length());
                wordList.add(vowelWordCounter);
                statistics.put(vowelKey, wordList);
            }
            else {
                if(statistics.get(vowelKey).stream().filter(o -> o.getWordLength() == word.length()).findFirst().isPresent()){
                    VowelWordCounter vowelWordCounter = statistics.get(vowelKey).stream().filter(o -> o.getWordLength() == word.length()).findFirst().get();
                    vowelWordCounter.increaseVowelCounter(vowelCounter);
                 //   int index = statistics.get(vowelKey).indexOf(vowelWordCounter);
                 //   statistics.get(vowelKey).add(index, vowelWordCounter);

                }
                else {
                    VowelWordCounter vowelWordCounter = new VowelWordCounter(vowelCounter, word.length());
                    statistics.get(vowelKey).add(vowelWordCounter);
                }

            }
            
            //System.out.println(word + " : " + word.length());
        }
        
    }
    
    private VowelKey getVowelKey(String word) {
        int totalVowelsCounter = 0;
        VowelKey vowelKey = new VowelKey();
        for (int i = 0; i < word.length(); ++i) {
            switch(word.charAt(i)) {
                case 'a':
                    vowelKey.add("a");
                    totalVowelsCounter++;
                    break;
                case 'e':
                    vowelKey.add("e");
                    totalVowelsCounter++;
                    break;
                case 'i':
                    vowelKey.add("i");
                    totalVowelsCounter++;
                    break;
                case 'o':
                    vowelKey.add("o");
                    totalVowelsCounter++;
                    break;
                case 'u':
                    vowelKey.add("u");
                    totalVowelsCounter++;
                    break;
            }

        }

        vowelKey.setTotalVowelsCount(totalVowelsCounter);
        return vowelKey;
    }
    
    /*
    * 
    *                 if(list.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent()){
                    
                }
    * */
}
