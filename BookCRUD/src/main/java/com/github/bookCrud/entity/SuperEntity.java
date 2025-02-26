package com.github.bookCrud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @UpdateTimestamp
    private Date updateTime;
    @Version
    private int recordVersion;
}
