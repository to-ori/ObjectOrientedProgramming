/*Student: Tori Hume
 * student ID: 11486248
 * Assignment 1
 */

public abstract class DirectoryComponent {

	//create an abstract setSize method to be overridden in supClasses
	public abstract int size();

	//getnumFiles() and getnumFolders() method are created. Unless overridden in a subclass they return 0.
	public int getnumFiles() {
		return 0;
	}

	public int getnumFolders() {
		return 0;
	}
}
