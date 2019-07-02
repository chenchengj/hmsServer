package config;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import constant.GeneralConstant;
import dao.HomeworkPublish;
import dao.HomeworkPublishExample;
import mapper.HomeworkPublishMapper;

public class MyTimerTask extends TimerTask {
	
	private HomeworkPublishMapper homeworkPublishMapper;
	
	@Override
	public void run() {
		homeworkPublishMapper = SpringContextUtil.getBeanByName(HomeworkPublishMapper.class);
		List<HomeworkPublish> list = homeworkPublishMapper.selectByExample(new HomeworkPublishExample());
		
		for (int i = 0; i < list.size(); i++) {
			HomeworkPublish homeworkPublish = list.get(i);
			Date date = new Date();
			if (date.after(homeworkPublish.getEndDate()) && !homeworkPublish.getStatus().equals(GeneralConstant.STATUS_DRAFT)) {
				homeworkPublish.setStatus(GeneralConstant.STATUS_ENDED);
				homeworkPublishMapper.updateByPrimaryKeySelective(homeworkPublish);
			}
		}
		
		System.out.println("——————————————————刷新完成——————————————————");
		
	}

}
