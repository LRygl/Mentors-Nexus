package com.mentors.NexusApplication.Model;

import java.util.Date;
import java.util.UUID;


public class Course {
    private Long id;
    private UUID courseId;
    private String courseName;
    private String courseDescription;
    private Long courseOwnerId;
    private Long courseCategoryId;

    private Date courseCreated;
    private Date coursePublishDate;
    private Date courseUpdated;

    private Boolean isPublished;
    private Boolean isPrivate;

}
