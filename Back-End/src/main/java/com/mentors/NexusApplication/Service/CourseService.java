package com.mentors.NexusApplication.Service;

import com.mentors.NexusApplication.Model.Course;

import java.io.IOException;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course addNewCourse(String courseName, String courseDescription, Long courseOwnerId, Long courseCategoryId) throws IOException;
}
