/*Student: Tori Hume
 * student ID: 11486248
 * Assignment 1
 */

import java.util.ArrayList;

public class Directory extends DirectoryComponent {
	//the class variables and arrays are created and declared
	private String name;
	private int numFiles;
	private int numFolders;
	private int size;

	/*An arraylists is created to store DirectoryComponent objects, (these can be files or Directories,
	*or objects from any class that extends the DirectoryComponent Class) in the directory.
	*/
ArrayList<DirectoryComponent> DirectoryList = new ArrayList<DirectoryComponent>();


	//constructor pulls from superclass
	public Directory(String nm){
		super();
	}


	//method to add a new DirectoryComponent object to the Directory list
	public void add(DirectoryComponent item) {
		this.DirectoryList.add(item);

	}
	//these getters and setters are used to allow the variables to be set to different values by method outside this class.
	public int getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	//method to calculate the size of all files in the folder and all files in the sub-folders.
	//the size of the "documents" folder itself is negligible so it is not added, we only account for the size of the files 
	public int size() {
		this.size= 0;
		for (DirectoryComponent item : DirectoryList){
			this.size += item.size();
		}
		return this.size;
	}


	//This method calculate the number of files in the directory and its sub-directories
	public int getnumFiles() {
		//initialize the variable numFiles 
		this.numFiles=0;

		/*An enhanced for loop is used to iterate through the arraylist.
		 * An if statement checks in the object at the "item" index is of type file
		 * If it is the numFiles variable is incremented by 1.
		 * Otherwise, it is a directory, and the the getnumFiles is called recursively to search
		 *  for files in the folder.
		 */
		for (DirectoryComponent item : DirectoryList){
			if(item instanceof File){
				this.numFiles ++;
			} else {
				this.numFiles += item.getnumFiles();
			}

		}

		return numFiles;
	}


	//This method counts the number of folders in a directory and its sub-directories

	public int getnumFolders() {
		//initialize the variable numFolders 
		this.numFolders=0;

		//an enhanced for loop is used to iterate through the array DirectoryList
		for(DirectoryComponent item: DirectoryList){

			/*this IF condition is used to check if the object in the current index 
			of the array is of type Directory
			 */
			if(item instanceof Directory){

				/*if the object is a directory the numfolder is incremented by 1, 
					and the method is called again to check for folders in that folder.
				 */
				this.numFolders ++;
				this.numFolders += item.getnumFolders();
			}
		}
		//the method then returns the total number of folders
		return numFolders;
	}


}

