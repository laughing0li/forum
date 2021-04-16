package com.whver.forum.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * this class is used for keep
 * all the avatars and post images
 * to find a avatar, need to state the type as avatar
 * and also need to use a whver id
 * */
@Data
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type; // the type of image, avatar or post images

    @ManyToOne
    @JoinColumn(name = "wid")
    private Whver publisher; // who post the image or this is an avatar of this user

    @ManyToOne
    @JoinColumn(name = "pid")
    private Post post; // the image belongs to which section

    @ManyToOne
    @JoinColumn(name = "mid")
    private Market market; // the image belongs to which section

}
