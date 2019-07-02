package config;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import constant.GeneralConstant;
import dao.HomeworkPublish;
import dao.HomeworkPublishExample;
import mapper.HomeworkPublishMapper;

@Component
public class InitServlet  implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private HomeworkPublishMapper homeworkPublishMapper;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			List<HomeworkPublish> list = homeworkPublishMapper.selectByExample(new HomeworkPublishExample());
			
			for (int i = 0; i < list.size(); i++) {
				HomeworkPublish homeworkPublish = list.get(i);
				Date date = new Date();
				if (date.after(homeworkPublish.getEndDate()) && !homeworkPublish.getStatus().equals(GeneralConstant.STATUS_DRAFT)) {
					homeworkPublish.setStatus(GeneralConstant.STATUS_ENDED);
					homeworkPublishMapper.updateByPrimaryKeySelective(homeworkPublish);
				}
			}
		}
		
		System.out.println("初始化完成！！！");		
	}

}
