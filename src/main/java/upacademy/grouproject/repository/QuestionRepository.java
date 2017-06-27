package upacademy.grouproject.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Questions;

@Named("questionRepository")
@Transactional
@RequestScoped
public class QuestionRepository extends EntityRepository<Questions>  {

	public List<Questions> getQuestions(String color){
		List<Questions> question = em.createQuery("Select e from Questions e where e.type = '" + color + "'", Questions.class).getResultList();
		return question;
	}
}
