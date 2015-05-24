package beginner;

import static constant.Constants.__;
import static org.junit.Assert.*;
import org.junit.Test;

public class AboutLoops {

	@Test
	public void basicForLoop() {
		String s = "";
		for(int i = 0; i < 5; i++) {
			s += i + " ";
		}
		assertEquals(s, "0 1 2 3 4 ");
	}
	
	@Test
	public void basicForLoopWithTwoVariables() {
		String s = "";
		for(int i = 0, j = 10; i < 5 && j > 5; i++, j--) {
			s += i + " " + j + " ";
		}
		assertEquals(s, "0 10 1 9 2 8 3 7 4 6 ");
	}
	
	@Test
	public void extendedForLoop() {
		int[] is = {1,2,3,4};
		String s = "-";
		for(int j : is) {
			s += "." + j;
		}
		assertEquals(s, "-.1.2.3.4");
	}
	
	@Test
	public void whileLoop() {
		int result = 0;
		while(result < 3) {
			result++;
		}
		assertEquals(result, 3);
	}
	
	@Test
	public void doLoop() {
		int result = 0;
		do {
			result++;
		} while(false);
		assertEquals(result, 1);
	}
	
	@Test
	public void extendedForLoopBreak() {
		String[] sa = {"Dog", "Cat", "Tiger" };
		int count = 0;
		for(String current : sa) {
			if("Cat".equals(current)) {
				break;
			}
			count++;	
		}
		assertEquals(count, 1);
	}
	
	@Test
	public void extendedForLoopContinue() {
		String[] sa = {"Dog", "Cat", "Tiger" };
		int count = 0;
		for(String current : sa) {
			if("Dog".equals(current)) {
				continue;
			} else {
				count++;	
			}
		}
		assertEquals(count, 2);
	}

	
	@Test
	public void forLoopContinueLabel() {
		int count = 0;
		outerLabel:
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++)
			{
				count++;
				if(count > 2) {
					continue outerLabel;	
				}
			}
			count += 10;
		}
		// What does continue with a label mean? 
		// What gets executed? Where does the program flow continue?
		assertEquals(count, 7);
	}
	
	@Test
	public void forLoopBreakLabel() {
		int count = 0;
		outerLabel:
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++)
			{
				count++;
				if(count > 2) {
					break outerLabel;	
				}
			}
			count += 10;
		}
		// What does break with a label mean? 
		// What gets executed? Where does the program flow continue?
		assertEquals(count, 3);
	}

}
