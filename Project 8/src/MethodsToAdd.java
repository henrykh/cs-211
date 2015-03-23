public class MethodsToAdd {
	public boolean containsAll(ArrayList<E> list){
		for(int i = 0; i<size; i++){
			if(!(list.contains(elements[i])){
				return false;
			}
		}
		return true;
	}
	
	public boolean remove(Object obj){
		for(int i=0; i<size; i++){
			if(elements[i].equals(obj)){
				int j = i+1;
				while(j<size){
					elements[i] = elements [j];
					j++;
				}
				size--;
				elements[size]=null;
			}
		}
	}
	
	public boolean removeAll(ArrayList<E> list){
		for(int i = 0; i<size; i++){
			if(list.contains(elements[i])){
				elements.remove(elements[i]);
			}
		}
	}
	
	public boolean retainAll(ArrayList<E> list){
		for(int i=0; i<size; i++){
			if(!(list.contains(elements[i])){
				elements.remove(elements[i]);
			}
		}
	}
	
	public int lastIndexOf(E item){
		int index = -1;
		for (int i = 0; i<size; i++){
			if(elements[i].equals(item)){
				index = i;
			}
		}
		return index;
	}
}