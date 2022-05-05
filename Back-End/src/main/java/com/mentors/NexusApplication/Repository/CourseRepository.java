package com.mentors.NexusApplication.Repository;

import com.mentors.NexusApplication.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByIsPublished(Boolean isPublished);
    List<Course> findByIsPrivate(Boolean isPrivate);
    //List<Course> findCoursesByUserId(Long userId);
    Course findCourseById(Long id);
}
