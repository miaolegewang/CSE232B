package ucsd.xpath.filereader;

import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
	static public void writeTo(String query, String filename){
		try{
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			writer.print(query);
			writer.close();
			System.out.println(filename + " created!");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
