package tla.vku.agentarena.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class HomeService {

  public Date getDate() {
    return new Date();
  }

  public String compileCode(String code) {
    try {
      File file = new File("/users/tmp/Chess.java");

      // if file doesnt exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(code);
      bw.close();

      System.out.println("Done");

      return compile(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "OKET";
  }
  
  private String compile(File directory) throws Exception {  
    // Compilation command  
    String cmd[] = new String[] { "javac", "-d", ".", "-cp", ".", "*.java" };  
    Process process = null;  
    BufferedReader errorReader = null;  
    try {  
        process = Runtime.getRuntime().exec(cmd, null, directory);  
        errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));  
    } catch (IOException e) {  
        return "Unable to launch Java complier. Please check you have install JDK";  
    }  
    try {  
        StringBuilder errorMessage = new StringBuilder();  
        String line = null;  
        while ((line = errorReader.readLine()) != null) {  
            errorMessage.append(line + "\n");  
        }  
        try {  
            int i = process.waitFor();  
            if (i != 0) {  
                return errorMessage.toString();  
            }  
        } catch (InterruptedException ignore) {  
        }  

    } catch (IOException ignore) {  
    } finally {  
        try {  
            errorReader.close();  
        } catch (IOException ignore) {  
            ignore.printStackTrace();  
        }  
    }  
    return null;  

}  

}
