/**
 * Counting Sundays http://projecteuler.net/problem=19
 * 
 * @author ken
 * 
 */

class Date {
	int startYear = 1900;
	final int[] daysInMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30,
			31, 30, 31 };
	int month;
	int day;
	int year;

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int calculateDay() {
		int d = 365 * (year - startYear) + numLeapYears();
		for (int i = 0; i < month; i++) {
			d += daysInMonth[i];
		}
		if (isLeapYear(this.year) && this.month > 1) {
			d++;
		}
		d += day;
		return d;
	}

	private boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0) {
				return true;
			}
		} else if (year % 4 == 0) {
			return true;
		}
		return false;
	}

	private int numLeapYears() {
		int count = 0;
		for (int i = 1900; i < year; i++) {
			if (isLeapYear(i)) {
				count++;
			}
		}
		return count;
	}
}

public class Problem19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numSundays = 0;
		for (int y = 1901; y <= 2000; y++) {
			for (int m = 0; m < 12; m++) {
				Date d = new Date(y, m, 1);
				int num = d.calculateDay();
				if (num%7 ==0) {
					numSundays++;
				}
			}
		}
		
		System.out.println(numSundays);
		System.exit(0);
	}

}
