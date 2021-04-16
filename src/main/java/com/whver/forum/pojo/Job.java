package com.whver.forum.pojo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String source; // the original source of this job

    private String industry;

    private String  content; // the general description of this job

    private Date publishDate;

    private boolean taxable; // is this job pay tax or not

    private boolean secondVisa; // this job can help people get their second visa or not

    private String address;

    @ManyToOne
    @JoinColumn(name = "cid")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "sid")
    private State state;

    @ManyToOne
    @JoinColumn(name = "wid")
    private Whver publisher; // many to one

    @Transient
    private List<Comment> commentList; // one to many


}
