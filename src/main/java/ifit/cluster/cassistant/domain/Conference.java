package ifit.cluster.cassistant.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conference  extends BaseEntity{

    private String name;
    private String info;

    @OneToMany(mappedBy = "conference", fetch = FetchType.LAZY)
    private List<Topic> topics;

}
