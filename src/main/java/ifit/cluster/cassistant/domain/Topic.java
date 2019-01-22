package ifit.cluster.cassistant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Topic {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String summary;
    private String speaker;
    private Date dateTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Conference conference;
//    private List<Question> questions;
    private Integer rate;

    public Topic() {
    }

    public Topic(String name, String summary, String speaker, Date dateTime, Conference conference, Integer rate) {
        this.name = name;
        this.summary = summary;
        this.speaker = speaker;
        this.dateTime = dateTime;
        this.conference = conference;
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

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
//
//    public List<Question> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<Question> questions) {
//        this.questions = questions;
//    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
