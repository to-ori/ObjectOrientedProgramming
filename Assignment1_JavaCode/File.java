/*Student: Tori Hume
 * student ID: 11486248
 * Assignment 1
 */

public class File extends DirectoryComponent {

	//class variables are created
	private String name;
	private int size;


	//overloaded constructor is created
	public File(String nm){
		super();
		this.setName(nm);
		this.setSize(nm.length());
		}

	//set size method is created to set the size equal to the number of charters in the files name.
	public void setSize(int length) {
		this.size=length;	
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

	//the size method, which is abstract in the superclass is implemented.
	@Override
	public int size() {
		return this.size;
	}

}
