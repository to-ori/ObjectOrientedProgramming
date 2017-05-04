//the fly class implements the behavior interface
public class Fly implements Behaviour{

	//it overrides the move method from behavior
	@Override 
	public void move(){
		System.out.println("Avatar has started to fly.\n\n");
	}

}
