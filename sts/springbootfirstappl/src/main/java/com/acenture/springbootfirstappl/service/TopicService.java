package com.acenture.springbootfirstappl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.acenture.springbootfirstappl.bean.Topic;

@Service
public class TopicService {
	List <Topic> topicList=new ArrayList<Topic>();
		
	{
		
	topicList.add(new Topic("Spring",12,"spring description"));
	topicList.add(new Topic("dotnet",89,".Net description"));
	topicList.add(new Topic("Javascript",44,"javasscript description"));
	
	}

	public List<Topic> getAllTopics() {
		
		return  topicList;
	}


	public Topic getTopic(int id) {
		/*for(Topic t:topicList)
		{
			if(t.getId()==id)
				return t;
		}*/
		
		return topicList.stream().filter(t -> t.getId()==id).findFirst().get();
		//return null;
	}


	public void addTopic(Topic topic) {
		topicList.add(topic);
	
	}
	
	

	
	

}
