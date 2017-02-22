package ucsd.xpath.filereader;

import java.util.ArrayList;
import java.util.List;

import java.io.*;

public class Readfile
{
    public static List<String> read(String filename){
        List<String> testcases = new ArrayList<String>();

        File file = new File(filename);
        BufferedReader br = null;

        try {
            java.io.FileReader fr = new java.io.FileReader(file);
            br = new BufferedReader(fr);
            String line;
            String hashtag = "###";
            String buffer = "";
            int counter = 0;
            
            System.out.println("file list:");
            
            while( (line = br.readLine()) != null ) {
            	if(line.length() == 3 && hashtag.equals(line)) {
//            		System.out.println(buffer);
            		testcases.add(buffer);
            		buffer = "";
                	counter++;
            	}else{
            		buffer += (line + '\n');            		
            	}
            }
            
            if(buffer.length() != 0){
//            	System.out.println(buffer);
        		testcases.add(buffer);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file.toString());
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println("Unable to close file: " + file.toString());
            }
            catch(NullPointerException ex) {
            }
        }
		return testcases;
    }
}
