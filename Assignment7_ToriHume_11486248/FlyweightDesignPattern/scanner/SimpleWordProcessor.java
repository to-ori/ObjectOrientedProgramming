package scanner;


import java.util.Scanner;

class SimpleWordProcessor {

	public static void main(String args[]){

		//declare variables
		String s;
		Scanner in = null;
		
		try{
			
			in= new Scanner(System.in);
			
			while(true){
				//ask user for input set equal to s
				System.out.print("Enter a string:");
				s = in.nextLine();
				
				//if they enter exit, exit the loop
				if(s.equals("exit")){
					System.out.println("exiting ");
					break; // breaks out of the while loop
				}
				
				//create a new document object and a new GlyphFactory
				
				Document doc = new Document();
				GlyphFactory factory=GlyphFactory.getInstance();
				//create a array of characters from the string inputed
				char[] word=s.toCharArray();
				
				//use a enhanced for loop to iterate through the array.
				// for each character in the array, get the glyph for it and add it to the doc
				for(Character c: word){
					doc.in(factory.getGlyph(c));
					
				}
				
				//call on the documents toSting to print the string
				System.out.println("You entered string "+doc.toString());

			}
		}finally{
			if(in!=null){
				//close the scanner
				in.close();
			}
		}
	}
}


