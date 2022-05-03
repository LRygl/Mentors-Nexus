package com.mentors.NexusApplication.Service.Impl;

import com.mentors.NexusApplication.Service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Qualifier("courseCategoryDetailsService")
public class CourseCategoryServiceImpl implements CourseCategoryService {
}
