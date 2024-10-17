package kr.co.test.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TriggerTest {

	public static void main(String[] args) {

		JobDetail job = JobBuilder.newJob(HelloJob.class)
				.withIdentity("job").build();

		JobDataMap jobDataMap = job.getJobDataMap();
		jobDataMap.put("name", "홍길동");

		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("trigger")
				//.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(2).repeatForever())
				.build();

		try {
			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.scheduleJob(job, trigger);
			scheduler.start();

			Thread.sleep(5000);

			// Job 하나만 중단
			//scheduler.deleteJob(job.getKey());

			// 전체 중단
			scheduler.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
