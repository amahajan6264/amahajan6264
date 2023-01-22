package java143;

import java.util.ArrayList;
import java.util.List;

public class forEachMethod {
	public static void main(String[] args) {
		List<String> gameList = new ArrayList<String>();
		gameList.add("football");
		gameList.add("Cricket");
		gameList.add("chess");
		gameList.add("hocky");
		System.out.println("Iterating by passing lambhda expression");
		gameList.forEach(games -> System.out.println(games));
	}
}
