package com.mentors.NexusApplication.Repository;

import com.mentors.NexusApplication.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
