package com.whver.forum.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;

    private Date publishDate;

    @ManyToOne
    @JoinColumn(name = "wid")
    private Whver publisher; // belong to whom

    @Transient
    private List<Image> images; // 需要有图片，图片可以为空，最多上传九张。大小也需要限制

    @Transient
    private List<Comment> comments;
}
