package com.mentors.NexusApplication.Service;

import com.mentors.NexusApplication.Exceptions.CourseCategoryNotFoundException;
import com.mentors.NexusApplication.Exceptions.CourseNotFoundException;
import com.mentors.NexusApplication.Model.Course;
import com.mentors.NexusApplication.Model.CourseCategory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface CourseCategoryService {
    List<CourseCategory> getAllCourseCategories();
    CourseCategory addNewCourseCategory(String courseCategoryName, String courseCategoryDescription,String courseCategoryCode, Boolean courseCategoryIsActive);
    CourseCategory deactivateCourseCategoryById(Long courseCategoryId) throws  CourseCategoryNotFoundException;
    CourseCategory updateCourseCategory(Long id, String courseCategoryName, String courseCategoryDescription, Boolean courseCategoryActive) throws CourseCategoryNotFoundException;
    void deleteCourseCategoryById(Long courseCategoryId);

}
