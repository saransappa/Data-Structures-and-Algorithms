public class CircularQueue {
	int f=-1,r=-1;
	int N=0;
	int [] arr;
	CircularQueue(int x){
		N=x;
		arr =new int[x];
	}
	public void enqueue(int value) {
		if(f == (r+1)%N) {
			System.out.println("Overflow Occured!!!");
		}
		else if(f==-1 && r==-1) {
			f=0;
			r=0;
			arr[f]=value;
		}
		else{
			r=(r+1)%N;
			arr[r]=value;
		}
	}
	public int dequeue() {
		if(f==-1 && r==-1) {
			System.out.println("Underflow Occured!!!");
			return -1;
		}
		else if(f==0 && r==0) {
			int k = arr[f];
			f=-1;
			r=-1;
			return k;
		}
		else{
			int k=arr[f];
			f=(f+1)%N;
			return k;
		}
		
	}
	public boolean isEmpty() {
		if(f==-1 && r==-1) {
			return true;
		}
		else {
			return false;
		}
	}
}
