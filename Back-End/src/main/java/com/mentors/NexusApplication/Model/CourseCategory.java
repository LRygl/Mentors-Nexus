package com.mentors.NexusApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="COURSE_CATEGORY")
public class CourseCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String courseCategoryName;
    private String courseCategoryDescription;
    @Column(length = 4)
    private String courseCategoryCode;
    private Date courseCategoryCreatedDate;
    private Date courseCategoryUpdatedDate;
    private Boolean isCourseCategoryActive;

    public CourseCategory() {
    }

    public CourseCategory(Long id, String courseCategoryName, String courseCategoryDescription, String courseCategoryCode, Date courseCategoryCreatedDate, Date courseCategoryUpdatedDate, Boolean isCourseCategoryActive) {
        this.id = id;
        this.courseCategoryName = courseCategoryName;
        this.courseCategoryDescription = courseCategoryDescription;
        this.courseCategoryCode = courseCategoryCode;
        this.courseCategoryCreatedDate = courseCategoryCreatedDate;
        this.courseCategoryUpdatedDate = courseCategoryUpdatedDate;
        this.isCourseCategoryActive = isCourseCategoryActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    public String getCourseCategoryDescription() {
        return courseCategoryDescription;
    }

    public void setCourseCategoryDescription(String courseCategoryDescription) {
        this.courseCategoryDescription = courseCategoryDescription;
    }

    public String getCourseCategoryCode() {
        return courseCategoryCode;
    }

    public void setCourseCategoryCode(String courseCategoryCode) {
        this.courseCategoryCode = courseCategoryCode;
    }

    public Date getCourseCategoryCreatedDate() {
        return courseCategoryCreatedDate;
    }

    public void setCourseCategoryCreatedDate(Date courseCategoryCreatedDate) {
        this.courseCategoryCreatedDate = courseCategoryCreatedDate;
    }

    public Date getCourseCategoryUpdatedDate() {
        return courseCategoryUpdatedDate;
    }

    public void setCourseCategoryUpdatedDate(Date courseCategoryUpdatedDate) {
        this.courseCategoryUpdatedDate = courseCategoryUpdatedDate;
    }

    public Boolean getCourseCategoryActive() {
        return isCourseCategoryActive;
    }

    public void setCourseCategoryActive(Boolean courseCategoryActive) {
        isCourseCategoryActive = courseCategoryActive;
    }
}
