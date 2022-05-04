package com.mentors.NexusApplication.Resource;

import com.mentors.NexusApplication.Exceptions.CourseCategoryNotFoundException;
import com.mentors.NexusApplication.Exceptions.CourseNotFoundException;
import com.mentors.NexusApplication.Model.Course;
import com.mentors.NexusApplication.Model.CourseCategory;
import com.mentors.NexusApplication.Service.CourseCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CourseCategoryResource {

    private final CourseCategoryService courseCategoryService;

    public CourseCategoryResource(CourseCategoryService courseCategoryService) {
        this.courseCategoryService = courseCategoryService;
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<CourseCategory>> getAllCategoryTypes(){
        List<CourseCategory> courseCategories =  courseCategoryService.getAllCourseCategories();
        return new ResponseEntity<>(courseCategories, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<CourseCategory> createNewCourseCategory(
        @RequestParam(value = "courseCategoryName") String courseCategoryName,
        @RequestParam(value = "courseCategoryDescription") String courseCategoryDescription,
        @RequestParam(value = "courseCategoryIsActive") Boolean courseCategoryIsActive,
        @RequestParam(value = "courseCategoryCode") String courseCategoryCode
        ){

        CourseCategory newCourseCategory = courseCategoryService.addNewCourseCategory(courseCategoryName,courseCategoryDescription,courseCategoryCode,courseCategoryIsActive);
        return new ResponseEntity<>(newCourseCategory,HttpStatus.OK);
        }

    @PutMapping(path = "/update")
    public ResponseEntity<CourseCategory> updateCourseCategory(@RequestBody CourseCategory courseCategory) throws CourseCategoryNotFoundException {
        CourseCategory updatedCourseCategory = courseCategoryService.updateCourseCategory(
                courseCategory.getId(),
                courseCategory.getCourseCategoryName(),
                courseCategory.getCourseCategoryDescription(),
                courseCategory.getCourseCategoryActive());
        return new ResponseEntity<>(updatedCourseCategory,HttpStatus.OK);
    }

    @PutMapping(path = "/{id}/deactivate")
    public ResponseEntity<CourseCategory> deactivateCourseCategory(@PathVariable(value = "id") Long courseCategoryId) throws CourseCategoryNotFoundException {
        CourseCategory courseCategory = courseCategoryService.deactivateCourseCategoryById(courseCategoryId);
        return new ResponseEntity<>(courseCategory,HttpStatus.OK);
    }

    @PutMapping(path = "/{id}/activate")
    public ResponseEntity<CourseCategory> activateCourseCategory(@PathVariable(value = "id") Long courseCategoryId){
        //TODO - MAke
        return null;
    }

    @DeleteMapping(path = "/{id}/delete")
    public boolean deleteCourseCategory(@PathVariable(value = "id") Long courseCategoryId){
        courseCategoryService.deleteCourseCategoryById(courseCategoryId);
        return true;
    }
}
