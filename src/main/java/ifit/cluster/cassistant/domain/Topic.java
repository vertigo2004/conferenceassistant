package ifit.cluster.cassistant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Topic extends BaseEntity{

    private String name;
    private String summary;
    private String speaker;
    private Date dateTime;
    private Integer rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Conference conference;




}
