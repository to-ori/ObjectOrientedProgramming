package scanner;


import java.util.LinkedList;

public class Document {
	
	//create a new String object
	String document;
	
	
	//A linkedList was chosen as it stores the object in the order they are added
	LinkedList<Glyph> doc = new LinkedList<Glyph>();	
	
	//this method adds a Glyph to the LinkedList;
	public void in (Glyph glyph){
		doc.add(glyph);
	}
	
	//this method iterates through the linkedList of glyphs and calls their getGlyph method which returns the Character
	//this is then concatenated onto the string document and finally the string is returned
	@Override
	public String toString(){
		document="";
		for(Glyph g: doc){
			document = document+ g.getGlyph();
		}
		return document;
		
	}

}
