package expr;

import java.util.Calendar;
import java.util.Date;  
import java.util.Timer;  
import java.util.TimerTask;  
import java.util.concurrent.Executors;  
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.TimeUnit;  
  
  
public class schedulerTaskTest  
{  
  
  
    public static void main(String[] args) throws InterruptedException  
    {  
  
        final TimerTask task1 = new TimerTask()  
        {  
  
            @Override  
            public void run()  
            {  
            	try {
            		System.out.println("task1 invoked!");
                    Integer.valueOf("ddd");
				} catch (Exception e) {
					e.printStackTrace();
					/*System.out.println(e.getMessage());*/
				}
            	  
            }  
        };  
  
        final TimerTask task2 = new TimerTask()  
        {  
        	int id = 1;
            @Override  
            public void run()  
            {  
                System.out.println("task2 invoked!");  
                System.out.println(id++);
            }  
        };  
          
          
          
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);  
        //pool.scheduleAtFixedRate(task1, 0, 500, TimeUnit.MILLISECONDS);  
        //pool.scheduleAtFixedRate(task2, 0 , 1000, TimeUnit.MILLISECONDS);  
        Timer timer = new Timer();
        //timer.scheduleAtFixedRate(task1, 0, 1000);
        
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -20);
        System.out.println(calendar.getTime());
    }  
}  