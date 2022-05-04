package com.mentors.NexusApplication.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private UUID courseId;
    private String courseName;
    private String courseDescription;
    private Long courseOwnerId;
    private Date courseCreated;
    private Date coursePublishDate;
    private Date courseUpdated;
    private Long courseCategoryId;
    private Boolean isPublished;
    private Boolean isPrivate;

    @ManyToOne
    @JoinColumn(name = "ID")
    private CourseCategory courseCategories;
    //MANYTOONE

    public Course() {
    }

    public Course(Long id, UUID courseId, String courseName, String courseDescription, Long courseOwnerId, Long courseCategoryId, Date courseCreated, Date coursePublishDate, Date courseUpdated, Boolean isPublished, Boolean isPrivate) {
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseOwnerId = courseOwnerId;
        this.courseCategoryId = courseCategoryId;
        this.courseCreated = courseCreated;
        this.coursePublishDate = coursePublishDate;
        this.courseUpdated = courseUpdated;
        this.isPublished = isPublished;
        this.isPrivate = isPrivate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public void setCourseId(UUID courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Long getCourseOwnerId() {
        return courseOwnerId;
    }

    public void setCourseOwnerId(Long courseOwnerId) {
        this.courseOwnerId = courseOwnerId;
    }

    public Long getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(Long courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public Date getCourseCreated() {
        return courseCreated;
    }

    public void setCourseCreated(Date courseCreated) {
        this.courseCreated = courseCreated;
    }

    public Date getCoursePublishDate() {
        return coursePublishDate;
    }

    public void setCoursePublishDate(Date coursePublishDate) {
        this.coursePublishDate = coursePublishDate;
    }

    public Date getCourseUpdated() {
        return courseUpdated;
    }

    public void setCourseUpdated(Date courseUpdated) {
        this.courseUpdated = courseUpdated;
    }

    public Boolean getPublished() {
        return isPublished;
    }

    public void setPublished(Boolean published) {
        isPublished = published;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }
}

