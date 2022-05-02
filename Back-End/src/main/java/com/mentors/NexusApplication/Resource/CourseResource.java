package com.mentors.NexusApplication.Resource;

import com.mentors.NexusApplication.Model.Course;
import com.mentors.NexusApplication.Service.CourseService;
import com.mentors.NexusApplication.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/course")
public class CourseResource {
private CourseService courseService;


    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addNewCourse(
            @RequestParam(value = "courseName") String courseName,
            @RequestParam(value = "courseDescription") String courseDescription,
            @RequestParam(value = "courseOwnerId") Long courseOwnerId,
            @RequestParam(value = "courseCategoryId") Long courseCategoryId
    ) throws IOException {

        Course newCourse = courseService.addNewCourse(courseName,courseDescription,courseOwnerId,courseCategoryId);
        return new ResponseEntity<>(newCourse,HttpStatus.OK);
    }
}
