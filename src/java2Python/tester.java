package java2Python;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;


public class tester {

	public static void main(String[] args) throws IOException, InterruptedException {
		try {
			//envPath, file, and args must be changed for each users and use
			String envPath = "E:/Anaconda/python";
			
			//String file = "E:/PythonCode/Assignment1A/MRNaturalJoin.py";
			File file = new File("E:/JavaCode/java2Python/src/files/MRNaturalJoin/MRNaturalJoin.py");
			File arg1 = new File("E:/JavaCode/java2Python/src/files/MRNaturalJoin/names.txt");
			File arg2 = new File("E:/JavaCode/java2Python/src/files/MRNaturalJoin/grades.txt");
			File arg3 = new File("E:/JavaCode/java2Python/src/files/MRNaturalJoin/output.txt");
			
			String command[] = {envPath,file.toString(),arg1.toString(), arg2.toString()};
			
			ProcessBuilder pb = new ProcessBuilder(command);
			
			Process p = pb.start();
					
			BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line = file.getName();
	        System.out.println("Running Python starts: " + line);
	        try {
		        PrintWriter opFile = new PrintWriter(arg3);
		        
		        
		        while ((line = bfr.readLine()) != null){
		        	opFile.println(line);
		            System.out.println(line);
		        }
		        
		        opFile.close();
	        } catch (IOException e) {
		          System.out.println("An error occurred.");
		          e.printStackTrace();
		        }
	        
		}catch(Exception e){System.out.println(e);}
		
		
	}
}


