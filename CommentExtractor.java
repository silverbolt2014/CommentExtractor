import java.util.Scanner;
import java.io.*;
//import java.lang.*;

public class CommentExtractor {
	public static void main (String[] args) throws IOException {
		
		if (args.length != 1) {
			System.out.println("Program usage: java CommentExtractor exampleFile.txt");
			System.exit(1);
		}
		
		String fileName = args[0];		
		Scanner input = new Scanner (new FileReader( fileName ));
				
		int count = 1;
		while ( input.hasNextLine() ){
			
			String currentLine = input.nextLine();	
			Scanner string_input = new Scanner(currentLine);

			if ( string_input.next().equals("/Contents") ) {
				String fullComment = string_input.nextLine().trim();
				String actualComment = fullComment.substring(1, fullComment.length()-1);
				String test = actualComment.replace("\r\n", "");
				
				//System.out.println(count + ": " + test);
				
				for (int i = 0; i < test.length(); i++) {
					System.out.println(test.charAt(i));
				}
			}
			count++;
			if (count == 41)  break;
		}
	}
}