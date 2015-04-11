package compiler;

public class Compteur {

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void increment() {
		value++;
	}

	public Compteur(int v) {
		value = v;
	}

}
