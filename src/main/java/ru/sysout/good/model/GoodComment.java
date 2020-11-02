package ru.sysout.good.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class GoodComment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String text;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,
            optional = true)
    @JoinColumn (name="topic_id")
    private GoodTopic topic;

    public GoodComment(String text) {
        this.text = text;
    }

}
