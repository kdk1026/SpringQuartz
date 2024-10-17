package kr.co.test.quartz;



import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		JobDataMap jobDataMap = ctx.getJobDetail().getJobDataMap();

		String sName = jobDataMap.getString("name");
		System.out.println(sName);
	}

}
