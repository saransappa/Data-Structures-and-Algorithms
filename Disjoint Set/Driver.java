
public class Driver {
	public static void main(String [] args) {
		int [] a ={10,20,30,40,50};
		DJSet ob = new DJSet(5,a);
		ob.union(10,50);
		ob.print();
	}
}
