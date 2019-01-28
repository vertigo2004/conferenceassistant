package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repo.QuestionRepo;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicRepo topicRepo;

    public List<Question> sortQuestion(Iterable<Question> questions) {
        List<Question> questionList = StreamSupport
                .stream(questions.spliterator(), false)
                .collect(Collectors.toList());
        Collections.sort(questionList, new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                return o2.getRate().compareTo(o1.getRate());
            }
        });
        return questionList;
    }

    public Question newQuestion(Long id, String text, String email){
        Topic t = topicRepo.getById(id);
        Question question = new Question(email, text, 0, t, Collections.singleton(State.NEW));
        questionRepo.save(question);
        return question;
    }

    public Question getQuestion(Long id) {
        return questionRepo.findById(id).get();
    }

    public Question likeQuestion(Long id, User user) {
        Question q = questionRepo.findById(id).get();
        if (!q.getLikes().contains(user)) {
            q.getLikes().add(user);
            q.setRate(q.getRate() + 1);
        } else {
            q.setRate(q.getRate() - 1);
            q.getLikes().remove(user);
        }
        return questionRepo.save(q);
    }
}
