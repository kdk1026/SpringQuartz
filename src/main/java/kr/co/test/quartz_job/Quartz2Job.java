package kr.co.test.quartz_job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import common.util.map.ResultSetMap;
import kr.co.test.function.service.MyBatisService;

public class Quartz2Job extends QuartzJobBean {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ApplicationContext ctx;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		ctx = (ApplicationContext) context.getJobDetail().getJobDataMap().get("applicationContext");

		MyBatisService myBatisService = (MyBatisService) ctx.getBean("myBatisServiceImpl");
		
		List<ResultSetMap> list = myBatisService.listUser();
		logger.debug("execute Quartz2Job task {}", list);
	}

}
