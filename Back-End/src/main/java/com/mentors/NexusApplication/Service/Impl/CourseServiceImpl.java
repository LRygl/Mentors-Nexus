package com.mentors.NexusApplication.Service.Impl;

import com.mentors.NexusApplication.Model.Course;
import com.mentors.NexusApplication.Repository.CourseRepository;
import com.mentors.NexusApplication.Service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.mentors.NexusApplication.Constants.FileConstant.COURSE_FOLDER;

@Service
@Transactional
@Qualifier("courseDetailService")
public class CourseServiceImpl implements CourseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @Override
    public Course addNewCourse(String courseName, String courseDescription, Long courseOwnerId, Long courseCategoryId) throws IOException {
        Course course = new Course();
        UUID courseUUID = UUID.randomUUID();
        Path coursePath =  Paths.get(COURSE_FOLDER + courseUUID);

        course.setCourseName(courseName);
        course.setCourseDescription(courseDescription);
        course.setCourseOwnerId(courseOwnerId);
        course.setCourseCategoryId(courseCategoryId);
        course.setCourseId(courseUUID);
        course.setCourseCreated(new Date());
        course.setCourseUpdated(new Date());
        course.setPrivate(false);
        course.setPublished(false);

        courseRepository.save(course);
        LOGGER.info("Created new course with id " + courseUUID);
        if(!Files.exists(coursePath)){
            Files.createDirectories(coursePath);
            LOGGER.info("Directory created " + coursePath);
        }
//done
        return course;
    }

    @PutMapping
    public Course updateCourse(){
        return null;
    }
    @DeleteMapping
    public Course deleteCourse(){
        return null;
    }
}
