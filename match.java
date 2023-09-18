
/*20.11 (MATCH GROUPING SYMBOLS) A Java program contains various pairs of grouping symbols, such as:
Parentheses: ( and )
Braces: { and }
Brackets: [ and ]

Note the grouping symbols cannot overlap. For example, (a{b)} 
is illegal. Write a program to check whether a Java source-code 
file has correct pairs of grouping symbols. Pass the source-code 
file name as a command-line argument.*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class match {
    public static void main(String[] args) throws IOException {
      File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("File could not be found");
			System.exit(1);
			}
      
        else if (args.length != 1) {
            System.err.println("Program accepts only one argument. Please put in File directory or name");
            System.exit(1);
        	}

        String files = args[0];

        if (matchmethod(files)) {
            System.out.println("Symbols in file match");
        	} 
        else {
            System.out.println("Symbols in file don't match");
        	}
    }

   static boolean matchmethod(String fileName) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        String line;
        int leftParenthesis = 0;
        int rightParenthesis = 0;
        int leftBracket = 0;
        int rightBracket = 0;
        int leftBraces = 0;
        int rightBraces = 0;

        while ((line = read.readLine()) != null) {
            for (char c : line.toCharArray()) {
            	switch (c){
                case '(':
                	leftParenthesis++;
                  break;
                case ')':
                	rightParenthesis++;
                  break;
                case '[':
                	leftBracket++;
                  break;
                case ']':
                	rightBracket++;
                  break;  
                case '{':
                	leftBraces++;
                  break;  
                case '}':
                	rightBraces++;
                  break;
            	}
            }
        }

        read.close();

        if  (leftParenthesis == rightParenthesis && leftBracket == rightBracket && leftBraces == rightBraces) {
        	return true;
        }
        else{
        	return false;
        }	
    }
}
