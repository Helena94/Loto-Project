package loto;

public class List {
	private int[] numbers;
	private int n;

	public List() {
		super();
		this.n = 0;
		this.numbers = new int[7];
	}

	public void addNumber(int number) {
		if ((!filledList()) && numberInRange(number) && !numberExist(number)) {
			numbers[n++] = number;
		}
	}

	public void changeNumber(int i, int number) {
		if (filledList() && numberInRange(number) && !numberExist(number))
			numbers[i] = number;

	}

	private boolean filledList() {
		return !(n < 7);
	}

	private boolean numberInRange(int number) {
		return number > 0 && number < 40;
	}

	private boolean numberExist(int number) {
		for (int i = 0; i < n; i++) {
			if (numbers[i] == number) {
				return true;
			}
		}
		return false;
	}

	public int number(int i) {
		if (filledList())
			return numbers[i];
		return 0;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public int getN() {
		return n;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < n - 1; i++)
			str += numbers[i] + ", ";
		str += numbers[n - 1] + "\n";
		return str;
	}

	@Override
	protected List clone() {
		// TODO Auto-generated method stub
		List l = new List();
		for (int number : numbers) {
			l.addNumber(number);
		}
		return l;
	}
}
