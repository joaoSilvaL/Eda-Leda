package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T retorno = null;
		if (!this.isEmpty()){
			retorno = this.array[0];
		}

		return retorno;
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.tail == this.array.length - 1;
	}

	private void shiftLeft() {
		for (int i = 0; i < tail; i++){
			this.array[i] = this.array[i + 1];
		}
		this.tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		if (this.isFull()){
			throw new QueueOverflowException();
		}
		else{
			this.tail ++;
			this.array[tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		if (this.isEmpty()){
			throw new QueueUnderflowException();
		}
		else{
			T temp = this.array[0];
			this.shiftLeft();
			return temp; 
		}
	}

}
