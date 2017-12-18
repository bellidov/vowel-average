package com.bellidov.language;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class VowelStatisticsService {

    private Map<Set<String>, List<VowelWordCounter>> statistics = new TreeMap<>();
    
    public Map<Set<String>, List<VowelWordCounter>> getVowelStatistics(String filePath) {
        
        
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(x -> this.handleText(x));
        } catch (IOException e) {
            System.out.println("Unable to read from the file " + filePath + " as it does not exist.");
        }
        
        return statistics;
    }
    
    private void handleText(String line) {
        String[] words = line.trim().replaceAll(" +", " ").toLowerCase().split(" ");
        
        for(String word : words) {
            int vowelCounter = 0;
            Set<String> vowelKey = getVowelKey(word, vowelCounter);
            
            if(!statistics.containsKey(vowelKey)) {
                List<VowelWordCounter> wordList = new LinkedList<>();
                VowelWordCounter vowelWordCounter = new VowelWordCounter(vowelCounter, word.length());
                wordList.add(vowelWordCounter);
                statistics.put(vowelKey, wordList);
            }
            else {
                if(statistics.get(vowelKey).stream().filter(o -> o.getWordLength() == word.length()).findFirst().isPresent()){
                    VowelWordCounter vowelWordCounter = statistics.get(vowelKey).stream().filter(o -> o.getWordLength() == word.length()).findFirst().get();
                    vowelWordCounter.increaseVowelCounter(vowelCounter);
                }
                else {
                    VowelWordCounter vowelWordCounter = new VowelWordCounter(vowelCounter, word.length());
                    statistics.get(vowelKey).add(vowelWordCounter);
                }

            }
            
            //System.out.println(word + " : " + word.length());
        }
        
    }
    
    private Set<String> getVowelKey(String word, int vowelCount) {
        
        Set<String> vowelKey = new TreeSet<>();
        for (int i = 0; i < word.length(); ++i) {
            switch(word.charAt(i)) {
                case 'a':
                    vowelKey.add("a");
                    vowelCount++;
                    break;
                case 'e':
                    vowelKey.add("e");
                    vowelCount++;
                    break;
                case 'i':
                    vowelKey.add("i");
                    vowelCount++;
                    break;
                case 'o':
                    vowelKey.add("o");
                    vowelCount++;
                    break;
                case 'u':
                    vowelKey.add("u");
                    vowelCount++;
                    break;
            }
            vowelCount++;
        }
        return vowelKey;
    }
    
    /*
    * 
    *                 if(list.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent()){
                    
                }
    * */
}
