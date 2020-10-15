package loto;

import java.util.Arrays;
import java.util.Random;

public class Loto {
	private List lotoList, userList;
	private final int randomNumber;

	private Random rnd;

	public Loto() {
		this(null);
	}

	public Loto(List userList) {
		super();
		this.rnd = new Random();
		this.randomNumber = this.rnd.nextInt(50) + 1;
		this.lotoList = new List();
		this.userList = userList;
	}

	public void drum() {
		int number = 0;
		if (this.rnd.nextInt(50) + 1 != randomNumber)
			while (lotoList.getN() < 7) {
				number = rnd.nextInt(39) + 1;
				lotoList.addNumber(number);
			}
		else {
			lotoList = userList.clone();
			if (this.rnd.nextInt(2) == 1) {
				int i = this.rnd.nextInt(7) + 1;
				int numberForChange = lotoList.number(i - 1);
				int number2 = lotoList.number(i - 1);
				do {
					number2  = rnd.nextInt(39) + 1;
				} while (number2  == numberForChange);
				lotoList.changeNumber(i - 1, number2);
			}

		}
	}

	public String strLotoList() {
		return lotoList.toString();
	}

	public String strUserList() {
		return userList.toString();
	}

	public List getLotoList() {
		return lotoList;
	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public int howMuchOfSameNumbers() {
		int numberOfSame = 0;
		int[] lUser = userList.getNumbers().clone();
		int[] lLoto = lotoList.getNumbers().clone();
		Arrays.sort(lUser);
		Arrays.sort(lLoto);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (lUser[i] == lLoto[j]) {
					numberOfSame++;
					break;
				}
			}
		}
		return numberOfSame;

	}
}
