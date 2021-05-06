package com.whver.forum.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Table(name = "comment")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    private String section; // this comment is come from posts or jobs or markets section

    private Date createTime;

    @ManyToOne
    @JoinColumn(name = "wid")
    private Whver publisher; // who made this comment

    @ManyToOne
    @JoinColumn(name = "pid")
    private Post post; // the comment belongs to which section

    @ManyToOne
    @JoinColumn(name = "mid")
    private Market market; // the comment belongs to which section

    @ManyToOne
    @JoinColumn(name = "jid")
    private Job job; // the comment belongs to which section

    @ManyToOne
    @JoinColumn(name = "cid")
    private Comment parentComment; // the main comment

    @Transient
    private List<Comment> replyComments; // the comments that reply to main comment
}








