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
		}
	}
}