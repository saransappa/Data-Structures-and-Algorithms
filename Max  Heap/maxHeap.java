public class maxHeap {
	int [] Heap;
	int size;
	maxHeap (int s){
		size=0;
		Heap = new int [s+1];
	}
	public int parent(int i) {
		return i/2;
	}
	public int leftChild(int i) {
		return 2*i;
	}
	public int rightChild(int i) {
		return (2*i)+1;
	}
	public void swap(int a,int b) {
		int temp = Heap[a];
		Heap[a] = Heap[b];
		Heap[b] = temp;
	}
	public void maxHeapify(int i) {
		int largest=0;
		int l = this.leftChild(i);
		int r = this.rightChild(i);
		if(l<=size && Heap[l]>Heap[largest]) {
			largest = l;
		}
		else {
			largest  = i;
		}
		if(r<=size && Heap[r]>Heap[largest]) {
			largest =r;
		}
		if(largest !=i) {
			this.swap(i, largest);
			maxHeapify(largest);
		}
		return;
	}
	public void insert(int a) {
		Heap[++size] = a;
		int c = size;
		while(this.parent(c)!=0 && Heap[c] > Heap[this.parent(c)]) {
			this.swap(c,this.parent(c));
			c=this.parent(c);
		}
	}
	public void delete(int pos) {
		Heap[pos] = Heap[size];
		size--;
		int c = pos;
		while(this.parent(c)!=0 && Heap[c] > Heap[this.parent(c)] ) {
			this.swap(c,this.parent(c));
			c=this.parent(c);
		}
		maxHeapify(c);
	}
	public void print() {
		for(int i=1;i<=size;i++) {
			System.out.println(Heap[i]);
		}
	}
	public int extractMax() {
		if (size<=0) {
			System.out.println("Heap Underflow");
			return -1;
		}
		int k = Heap[1];
		delete(1);
		return k;
	}
	public void buildMaxHeap() {
		for(int i= size/2;i >0;i--) {
			maxHeapify(i);
		}
	}
}
