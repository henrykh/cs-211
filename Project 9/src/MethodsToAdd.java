public class MethodsToAdd {
	public void add(int index, int value){
		if(index == 0){
			front = new ListNode(value, front);
		}
		else {
			ListNode current = front;
			for (int i=0; i<index-1; i++){
				current = current.next;
			}
			current.next = new ListNode(value, current.next);
		}
	}
	
	public void stretch(int n){
		ListNode current = front;
		while(current.next!=null){
			int number = current.value;
			for(int i=0; i<n; i++){
				add(current.next, number);
				current=current.next;
			}
		}
	}
}