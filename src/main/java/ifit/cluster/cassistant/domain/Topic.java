package ifit.cluster.cassistant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String summary;
    private String speaker;
    private Calendar dateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Conference conference;

    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private List<Question> questions;
    private Integer rate;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> likes;

    public Topic() {
    }

    public Topic(String name, String summary, String speaker, Calendar dateTime, Conference conference, List<Question> questions, Integer rate) {
        this.name = name;
        this.summary = summary;
        this.speaker = speaker;
        this.dateTime = dateTime;
        this.conference = conference;
        this.questions = questions;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getSpeaker() {
        return speaker;
    }
    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
    public Calendar getDateTime() {
        return dateTime;
    }
    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }
    public Conference getConference() {
        return conference;
    }
    public void setConference(Conference conference) {
        this.conference = conference;
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public Integer getRate() {
        return rate;
    }
    public void setRate(Integer rate) {
        this.rate = rate;
    }
    public Set<User> getLikes() {
        return likes;
    }
    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }
}