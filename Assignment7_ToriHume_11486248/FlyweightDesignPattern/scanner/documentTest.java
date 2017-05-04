package scanner;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//this is teh junit test call used for assignment7
public class documentTest {

	Document doc;
	GlyphFactory factory, factory2;
	Character a;
	Glyph test1, test2;
	
	@Before
	public void setUp() throws Exception {
		doc = new Document();
		factory=GlyphFactory.getInstance();
		
		
	}

	//test that a key(char) and value(glyph) are added to the hashmap;
	@Test
	public void HashMaptest() {
		assertFalse(factory.getGlyphPool().containsKey(a));
		test1=factory.getGlyph(a);
		assertTrue(factory.getGlyphPool().containsKey(a));
		assertTrue(factory.getGlyphPool().containsValue(test1));
	
	}
	
	//test a glyph is added to a doc.
	@Test
	public void DocStringTest(){
		String expectedString="hello";
		String s = "hello";
		
		Document doc = new Document();
		GlyphFactory factory=GlyphFactory.getInstance();
		char[] word=s.toCharArray();
		for(Character c: word){
			doc.in(factory.getGlyph(c));
		}
		String actualString=doc.toString();
		
		assertEquals(expectedString, actualString);
		
	}

	//test to insure there is only ever one instance of glyphFactory
	@Test
	public void singltionTest(){
		factory2 = GlyphFactory.getInstance();
		assertTrue(factory.equals(factory2));
	}
	
	//for a known key, a reference to a glyph is returned and a new one is not created
	@Test
	public void glyphtest(){
		test1=factory.getGlyph(a);
		test2 = factory.getGlyph(a);
		assertEquals(test1, test2);
	}
}
