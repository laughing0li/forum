package com.whver.forum.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Entity
@Table(name = "market")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title; // what's this post for

    private String content; // the general description of this job

    private Date publishDate;

    private String address;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "sid")
    private State state;

    @ManyToOne
    @JoinColumn(name = "wid")
    private Whver publisher; // one to many

    @Transient
    private List<Comment> commentList;

    @Transient
    private List<Image> images;
}
