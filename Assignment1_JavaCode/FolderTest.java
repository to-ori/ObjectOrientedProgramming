import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FolderTest {
	//class variables are created
	Directory documents, dylan, photos,music, band;
	File a, b, c ,d, f ,e;

	//the @before tag insures that the details in the setUp method are used as the "setup" of each test.
	//i.e. any changes to these variables that are made by one test will not effect any other text.
	@Before
	public void setUp() throws Exception {
		documents = new Directory("Documents");
		music = new Directory("Music");
		photos = new Directory("Photos");
		dylan = new Directory("Dylan"); 
		band = new Directory("Band");
		

		a = new File("assign1.doc");
		b = new File("family.jpg"); 
		c = new File("tambourine.pm3"); 
		d = new File("dixie.mp3");
		e = new File("weight.mp3");

		documents.add(a);
		documents.add(music);
		documents.add(photos);
		photos.add(b);
		
		music.add(dylan);
		music.add(band);
		dylan.add(c);
		band.add(d);
		band.add(e);
	}

	/*this method contains the testSize method. It was used to aid in the development of the size method. 
	it tests the method and insures the size computed is equal to the size of all the files in the 
	directory and sub directories of that directory.
	 */
	@Test
	public void testSize() {
		int expectedSize = 54;


		// results returned from the code
		int sizeResult = documents.size();

		assertEquals(expectedSize, sizeResult);

	}
	//numFiles(): returns the number of files in any folder, including those in its sub-folders
	@Test
	public void TestNumFiles() {
		// expected results
		int expectedNumFiles = 5;

		// results returned from the code
		int numFilesResult = documents.getnumFiles();

		assertEquals(expectedNumFiles, numFilesResult);
	}

	//getnumFolders() method counts the number of folders in a directory and its sub-directories 
	
	@Test
	public void TestNumFolders(){
		// expected results
		int expectedNumFolders = 4;

		// results returned from the code
		int numFoldersResult = documents.getnumFolders();
		assertEquals(expectedNumFolders, numFoldersResult);
	}
}
