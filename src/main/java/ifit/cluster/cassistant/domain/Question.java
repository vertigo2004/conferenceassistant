package ifit.cluster.cassistant.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String email;
    private String text;
    private int rate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Topic topic;

    @ElementCollection(targetClass = State.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "question_state", joinColumns = @JoinColumn(name = "question_id"))
    @Enumerated(EnumType.STRING)
    private Set<State> state;


}
