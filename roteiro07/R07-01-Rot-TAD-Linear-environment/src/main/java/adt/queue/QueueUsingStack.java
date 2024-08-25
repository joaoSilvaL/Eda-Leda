package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.stack1.isFull()){
			throw new QueueOverflowException();
		}
		try{
			this.stack1.push(element);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T retorno = null;
		if (this.stack1.isEmpty()){
			throw new QueueUnderflowException();
		}
		try{
			this.alternaPilha();
			retorno = this.stack2.pop();
			this.alternaPilha();
		} catch (Exception e){
			e.printStackTrace();
		}

		return retorno;

	}

	@Override
	public T head() {
		T retorno = null;
		if (!this.isEmpty())
		try{
			this.alternaPilha();
			retorno = this.stack2.top();
			this.alternaPilha();
		}catch (Exception e){
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

	private void alternaPilha(){
		if (this.stack2.isEmpty()){
			while (!this.stack1.isEmpty()) {
				try{
					this.stack2.push(this.stack1.pop());
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		else{
			while (!this.stack2.isEmpty()) {
				try{
					this.stack1.push(this.stack2.pop());
				}
				catch (Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}

}
