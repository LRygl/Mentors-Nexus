package com.mentors.NexusApplication.Resource;

import com.mentors.NexusApplication.Exceptions.CourseNotFoundException;
import com.mentors.NexusApplication.Model.Course;
import com.mentors.NexusApplication.Model.HttpResponse;
import com.mentors.NexusApplication.Service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/course")
public class CourseResource {
    private final CourseService courseService;

    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(path ="/list/all")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(path = "/list/published")
    public ResponseEntity<List<Course>> getAllPublishedCourses(){
        List<Course> courses = courseService.getAllPublishedCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('user:delete')")
    @GetMapping(path = "/list/private")
    public ResponseEntity<List<Course>> getAllPrivateCourses(){
        return null;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Course> getCourseByCourseId(@PathVariable(value = "id",name = "id") Long id) throws CourseNotFoundException {
        Course course = courseService.findCourseById(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
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

    @PutMapping(path = "/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) throws CourseNotFoundException {
        Course updatedCourse = courseService.updateCourse(
                course.getId(),
                course.getCourseName(),
                course.getCourseDescription(),
                course.getCourseOwnerId(),
                course.getCourseCategoryId(),
                course.getCoursePublishDate(),
                course.getPrivate(),
                course.getPublished());
        return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<HttpResponse> deleteCourse(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .httpStatusCode(HttpStatus.OK.value())
                        .httpTimestamp(new Date(System.currentTimeMillis()))
                        .httpResponseData(Map.of("Deleted",courseService.deleteCourseById(id)))
                        .httpStatusMessage("Course deleted " + id)
                        .httpDeveloperMessage("Oops")
                        .httpStatusReason("test")
                        .build()
        );
    }



}
