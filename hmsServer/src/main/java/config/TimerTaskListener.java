package config;

import java.util.Calendar;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimerTaskListener implements ServletContextListener {
	
	private Timer timer = null;

	public void contextDestroyed(ServletContextEvent arg0) {
		timer.cancel();
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("————————————————启动定时器————————————————————");
		Calendar now = Calendar.getInstance();
		now.set(Calendar.HOUR_OF_DAY, 23);
		now.set(Calendar.MINUTE, 50);
		now.set(Calendar.SECOND, 0);
		timer = new Timer(true);
		//第一次是晚上23点执行，间隔24小时执行一次
		timer.schedule(new MyTimerTask(), now.getTime(), 1000*60*60*24);
	}

}
