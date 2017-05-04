package scanner;

import java.util.HashMap;
import java.util.Map;

//a flyweight class implemented as a singleton
public class GlyphFactory {

	//this creates a private instance of this class
	private static GlyphFactory instance = new GlyphFactory();
	
	//a private constructor so it can't be accessed and create new instances of this class 
	private GlyphFactory(){}
	
	//this method returns the instance. 
	public static GlyphFactory getInstance(){
		return instance;
	}
	
	//this is a private hashmap that will contain all the Glyphs
	private Map<Character, Glyph> glyphPool = new HashMap<Character, Glyph>();
	
	//this method return the glyph associated with the character entered.
	//if one isn't already contained in the hashMap it will create a new one and add it to the hashmap
	//it will then return the glyph
	public Glyph getGlyph(Character character){
		Glyph glyph = getGlyphPool().get(character);
		
		if(glyph==null){
			glyph = new Glyph(character);
			getGlyphPool().put(character, glyph);
		}
		
		return glyph;
	}

	//this is used to access the hashmap
	//it was used in Junit tests
	public Map<Character, Glyph> getGlyphPool() {
		return glyphPool;
	}

	
	
}
