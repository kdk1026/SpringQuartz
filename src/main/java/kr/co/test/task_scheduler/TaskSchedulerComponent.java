package kr.co.test.task_scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import common.LogDeclare;
import common.spring.resolver.ParamCollector;
import common.util.date.JodaTimeDateUtil;
import common.util.map.ResultSetMap;
import kr.co.test.function.service.MyBatisService;

@Component
public class TaskSchedulerComponent extends LogDeclare {
	
	@Autowired
	private MyBatisService myBatisService;
	
	@Scheduled(fixedDelay = 10000)
	public void runFixedDelay() {
		logger.debug("execute runFixedDelay() task {}", JodaTimeDateUtil.Today.getTodayString());
	}
	
	@Scheduled(fixedRate = 12000)
	public void runFixedRate() {
		ParamCollector paramCollector = new ParamCollector();
		paramCollector.put("id", "1");
		
		ResultSetMap resMap = myBatisService.getUser(paramCollector);
		logger.debug("execute runFixedRate() task {}", resMap);
	}
	
	@Scheduled(cron = "*/15 * * * * MON-FRI")
	public void runCron() {
		logger.debug("execute runCron() task {}", JodaTimeDateUtil.Today.getTodayString());
	}
	
}
