package kr.co.test.quartz_job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import common.util.date.JodaTimeDateUtil;

public class Quartz1Job extends QuartzJobBean {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.debug("execute Quartz1Job task {}", JodaTimeDateUtil.Today.getTodayString());
	}

}
