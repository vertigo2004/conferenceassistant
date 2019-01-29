package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repo.QuestionRepo;
import ifit.cluster.cassistant.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private TopicRepo topicRepo;
    @Autowired
    private TopicService topicService;

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
        q = (Question)topicService.likeOrDisLike(user, q);
        return questionRepo.save(q);
    }

    public void changeState(Long questionId, String state){
        Question q = getQuestion(questionId);
        Set<State> set = new HashSet<>();
        set.add(State.valueOf(state));
        q.setState(set);
        questionRepo.save(q);
    }

    public List<Enum<State>> loadStates() {
        List<Enum<State>> states = new ArrayList<>();
        states.add(State.NEW);
        states.add(State.IN_PROGRESS);
        states.add(State.ANSWERED);
        states.add(State.REMOVED);
        return states;
    }
}
