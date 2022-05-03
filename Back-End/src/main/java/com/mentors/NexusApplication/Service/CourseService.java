package com.mentors.NexusApplication.Service;

import com.mentors.NexusApplication.Exceptions.CourseNotFoundException;
import com.mentors.NexusApplication.Model.Course;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    List<Course> getAllPublishedCourses();
    void updateAllCoursesPublishedState();
    Course updateCourse(Long id, String courseName, String courseDescription, Long courseOwnerId, Long courseCategoryId, Date coursePublishedDate, Boolean courseIsPrivate, Boolean courseIsPublished) throws CourseNotFoundException;
    Course addNewCourse(String courseName, String courseDescription, Long courseOwnerId, Long courseCategoryId) throws IOException;
    Course findCourseById(Long id) throws CourseNotFoundException;

    Boolean deleteCourseById(Long id);
}
