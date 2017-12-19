package com.bellidov.language;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MainApp {
    
   // private Map<>
    private List<String> lines = new ArrayList<>();
    
    public static void main(String[] args) {
        String filePath = "D:\\input.txt";//args[0];
        File file = new File(filePath);
        
        if(file.exists() && file.isFile()) {

            VowelStatisticsService service = new VowelStatisticsService();

            Map<VowelKey, List<VowelWordCounter>> results = service.getVowelStatistics(file.getAbsolutePath());

            List<String> lines = new ArrayList<>();
            for (Map.Entry<VowelKey, List<VowelWordCounter>> entry : results.entrySet()){
                for(VowelWordCounter counter : entry.getValue()) {
                    lines.add("(" + entry.getKey() + ", " + counter.getWordLength() + ") -> " + (double)counter.getVowelCounter() / counter.getWordCounter());
                }

            }

            Path outFile = Paths.get(Paths.get(filePath).getParent().toString(), "output.txt");
            try {
                Files.write(outFile, lines, Charset.forName("UTF-8"));
                System.out.println("The file " + outFile.toString() + " was created.");
            } catch (IOException e) {
                System.out.println("Unable to create the file " + outFile.getFileName());
            }

        }
        else {
            System.out.println("The provided value is not a valid file path.");
        }
    }
    
}
