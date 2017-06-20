package upacademy.grouproject.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import upacademy.grouproject.model.Questions;
import upacademy.grouproject.repository.QuestionRepository;

@Named("questionService")
@RequestScoped
public class QuestionService extends EntityService<Questions> {

	public List<Questions> getQuestions(String color){
		
		QuestionRepository er = (QuestionRepository)this.er;
		return er.getQuestions(color);
	}	
}
