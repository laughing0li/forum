package com.whver.forum.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
/**
 * this class is used for keep a
 * whver's collections of posts or jobs
 */

@Data
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Entity
@Table(name = "save")
public class Save {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "wid")
    private Whver whver;

    @Transient
    private List<Job> jobs;

    @Transient
    private List<Market> markets;

}
