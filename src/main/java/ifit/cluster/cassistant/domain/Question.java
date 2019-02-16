package ifit.cluster.cassistant.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.Set;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String email;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Topic topic;

    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> likes;

    public Question() {
    }

    public Question(String email, String text, Topic topic, State state) {
        this.email = email;
        this.text = text;
        this.topic = topic;
        this.state = state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }

    public Topic getTopic() {
        return topic;
    }

    public State getState() {
        return state;
    }

    public Set<User> getLikes() {
        return likes;
    }

    @Transient
    public int getRate(){
        return likes == null ? 0 : likes.size();
    }
}
