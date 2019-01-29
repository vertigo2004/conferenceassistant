package ifit.cluster.cassistant.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question extends BaseEntity {

    private String email;
    private String text;
    private Integer rate;

    @ManyToOne(fetch = FetchType.EAGER)
    private Topic topic;

    @ElementCollection(targetClass = State.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "question_state", joinColumns = @JoinColumn(name = "question_id"))
    @Enumerated(EnumType.STRING)
    private State state;

}
