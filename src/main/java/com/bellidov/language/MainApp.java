package com.bellidov.language;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainApp {
    
   // private Map<>
    private List<String> lines = new ArrayList<>();
    
    public static void main(String[] args) {
        String filePath = args[0];
       // File file = new File(filePath);
        
     //   if(file.exists() && file.isFile()) {
            
            try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
                stream.forEach(x -> System.out.println(x));
            } catch (IOException e) {
                System.out.println("Unable to read from the file " + filePath + " as it does not exist.");        
            }
                
  //      }
  //      else {
  //          System.out.println("The provided value is not a valid file path.");
  //      }
    }
    
}
