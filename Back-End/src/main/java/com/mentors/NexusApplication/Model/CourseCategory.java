package com.mentors.NexusApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="COURSE_CATEGORY")
public class CourseCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String courseCategoryName;
    private String courseCategoryDescription;
    private Date courseCategoryCreatedDate;
    private Date courseCategoryUpdatedDate;
    private Boolean isCourseCategoryActive;
}
