package leetcode_contest_39;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Q_2 {

	public static void main(String[] args) throws ParseException {
		// create test case
		LogSystem obj = new LogSystem();
		obj.put(1, "2017:01:01:23:59:59");
		obj.put(2, "2017:01:01:22:59:59");
		obj.put(3, "2016:01:01:00:00:00");

		List<Integer> result = obj.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year");
		System.out.println("result is: " + result.toString());
	}

	public static class LogSystem {

		private List<Date> logs;
		private List<Integer> id;

		public LogSystem() {
			logs = new ArrayList<Date>();
			id = new ArrayList<Integer>();
		}

		public void put(int id, String timestamp) throws ParseException {
			Date date = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").parse(timestamp);

			if (logs.isEmpty()) {
				logs.add(date);
				this.id.add(id);
				return;
			}

			for (int i = 0; i < logs.size(); i++) {
				if (logs.get(i).compareTo(date) == 1) {
					logs.add(i, date);
					this.id.add(i, id);
					break;
				}
			}
			System.out.println(this.id.toString());

		}

		public List<Integer> retrieve(String s, String e, String gra) throws ParseException {
			Date start = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").parse(s);
			Date end = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").parse(e);
			List<Integer> result = new ArrayList<Integer>();

			if (gra.toLowerCase().equals("year")) {
				for (int i = 0; i < logs.size(); i++) {
					if (withinYear(start, end, logs.get(i)))
						result.add(id.get(i));
				}
			} else if (gra.toLowerCase().equals("month")) {
				for (int i = 0; i < logs.size(); i++) {
					if (withinMonth(start, end, logs.get(i)))
						result.add(id.get(i));
				}
			}

			return result;
		}

		private boolean withinYear(Date s, Date e, Date d) {
			Calendar c = Calendar.getInstance();
			c.setTime(s);
			int yS = c.get(Calendar.YEAR);
			c.setTime(e);
			int yE = c.get(Calendar.YEAR);
			c.setTime(d);
			int yD = c.get(Calendar.YEAR);
			return (yD >= yS && yD <= yE);
		}

		private boolean withinMonth(Date s, Date e, Date d) {
			Calendar c = Calendar.getInstance();
			c.setTime(s);
			int yS = c.get(Calendar.MONTH);
			c.setTime(e);
			int yE = c.get(Calendar.MONTH);
			c.setTime(d);
			int yD = c.get(Calendar.MONTH);
			return (yD >= yS && yD <= yE);
		}
		
		private boolean withinDay(Date s, Date e, Date d) {
			Calendar c = Calendar.getInstance();
			c.setTime(s);
			int yS = c.get(Calendar.DAY_OF_MONTH);
			c.setTime(e);
			int yE = c.get(Calendar.DAY_OF_MONTH);
			c.setTime(d);
			int yD = c.get(Calendar.DAY_OF_MONTH);
			return (yD >= yS && yD <= yE);
		}
	}
}
