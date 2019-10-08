package ru.project.accountsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Admin on 18.05.2019.
 */
@Getter
@Setter
public class IndexWorkerFindDTO implements Serializable {

    public IndexWorkerFindDTO() {}

    private Date dateBegin;
    private Date dateEnd;
}
