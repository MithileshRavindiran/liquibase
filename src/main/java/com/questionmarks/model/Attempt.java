package com.questionmarks.model;

/**
 * Created by mravindran on 25/10/17.
 */

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "alternative_id")
    private Alternative alternative;

    @NotNull
    private Date date;

    private boolean correct;
}