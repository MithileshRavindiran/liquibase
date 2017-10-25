package com.questionmarks.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by mravindran on 25/10/17.
 */

@Data
@Entity
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private long order;

    @NotNull
    private String description;

    private boolean correct;

}
