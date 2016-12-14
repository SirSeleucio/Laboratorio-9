import java.util.Scanner;

public class Es1 {
	public static void main(String[] args) {
		ArrayStack x = new ArrayStack();
		x.push(1);
		x.push(2);
		x.push(3);
		x = reverseStack1(x);
		while (!x.isEmpty()) {
			System.out.println(x.pop());
		}

	}
	public static ArrayStack reverseStack1(ArrayStack a) {
		ArrayStack temp = new ArrayStack();
		while (!a.isEmpty()) {
			temp.push(a.pop());
		}
		return temp;
	}
}
