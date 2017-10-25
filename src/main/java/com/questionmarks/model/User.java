package com.questionmarks.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by mravindran on 25/10/17.
 */
@Data
@Entity
public class User {

    @Id
    private String id;
}
