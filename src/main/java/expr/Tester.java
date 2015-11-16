package expr;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;



public class Tester {
	public final static SimpleDateFormat SIMPLE_DATE = new SimpleDateFormat("yyyyMMdd");
	
	public static void test1(String[] args) {
		LocalDate date = LocalDate.of(2012, 9, 10);
		System.out.println(date.getDayOfWeek());
		for (int i = 0; i < 158; i++) {
			//System.out.print(i+1);
			System.out.print(" ");
			System.out.println(date);
			date = date.plusDays(7);
		}
		Date date2 = new Date();
		String value = SIMPLE_DATE.format(date2);
		System.out.println(date2);
		System.out.println(value);
	}
	
	public static void test2() throws  Exception{
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        FileReader fr = new FileReader("d:/cities.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        StringBuffer sb = new StringBuffer();
        while(line != null && br != null){
            String pro = line.trim();
            br.readLine();
            String cities = br.readLine();
            if (cities == null) {
				System.out.println(cities);
			}
            String[] cs = cities.split("[\\t|\\s+]");
            List<String> cl = Arrays.asList(cs);
            map.put(pro, cl);
            line = br.readLine();
            for(String city : cs){
                if (city.isEmpty()) continue;
                sb.append("('"+pro+"','"+city+"'),");
            }
        }
        br.close();
        String sql = sb.toString();
        System.out.println(sql.substring(0, sql.length()-1));
    }
	
	public static void test3() {
		//Scanner st = new Scanner("$12.0-23");
		String str = "dd12";
		/*Scanner st = new Scanner(str);
		while (!st.hasNextDouble()) {
			st.next();
		}
		double value = st.nextDouble();
		System.out.println(value);
		*/

		Matcher m = Pattern.compile("\\d+\\.?\\d+").matcher(str);
		if(!m.matches()){
			if(m.find()){
				System.out.println(m.group());
			}
		}
	}
	
	public static void test4(){
		String a = "_123";
		for (String item : a.split("_")) {
			System.out.println(item);
		}
	}
	
	public static void parseJson() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(new File("d:/items.dat")));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("d:/item.txt")));
		String line = reader.readLine();
		while (line != null) {
			JSONObject jsonObject = JSONObject.parseObject(line);
			String item = jsonObject.getString("param");
			writer.write(item);
			writer.newLine();
			line = reader.readLine();
		}
		writer.close();
		reader.close();
		
		
	}
	
	public static void test5(){
		Long time = 1444742553000L;
		System.out.println(new Date(time));
		String a = "7138570858_2015101621";
		System.out.println(a.length());
		
	}
	
	
	public static void test6() throws Exception{
		System.out.println("Started");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		final Date begin = dateFormat.parse("20151110 01:01:30");
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			boolean first = true;
			@Override
			public void run() {
				System.out.println(new Date());
				Date beginDate = null;
				Date endDate = new Date();
				if (first) {
					beginDate = begin;
					first = false;
				}else {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(new Date());
					calendar.add(Calendar.DATE, -31);
					beginDate = calendar.getTime();
				}
				System.out.println("#####");
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		};
		//timer.scheduleAtFixedRate(task, begin, 1000*60);
		//timer.schedule(task, begin, 60*1000);
		LocalDateTime time = LocalDateTime.now();
		//timer.schedule(task, 1000*(60-time.getSecond()), 8000);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String tgStr = format.format(date).substring(0, 8)+"010000";
		Date tg = format.parse(tgStr);
		System.out.println("The started time is: "+tg);
		timer.scheduleAtFixedRate(task, tg, 1000*3600*24);

	}
	
	public static void test7() throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String tgStr = format.format(date).substring(0, 8)+"010000";
		Date tg = format.parse(tgStr);
		System.out.println(date);
		System.out.println(tgStr);
		System.out.println(tg);
	}
	
	public static void main(String[] args) throws Exception{
		test5();
	}
}
