package ifit.cluster.cassistant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String text;
    private int rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Topic topic;
    @ElementCollection(targetClass = State.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "question_state", joinColumns = @JoinColumn(name = "question_id"))
    @Enumerated(EnumType.STRING)
    private Set<State> state;

    public Question() {
    }

    public Question(String email, String text, int rate, Topic topic, Set<State> state) {
        this.email = email;
        this.text = text;
        this.rate = rate;
        this.topic = topic;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Set<State> getState() {
        return state;
    }

    public void setState(Set<State> state) {
        this.state = state;
    }
}