package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.CurriculumCourse;
import vn.edu.iuh.fit.repositories.CurriculumCourseRepository;

import java.util.List;

@RestController
@RequestMapping("/curriculum-courses")
@CrossOrigin(origins = "*")
public class CurriculumCourseController {
    @Autowired
    private CurriculumCourseRepository curriculumCourseRepository;

    @GetMapping
    public List<CurriculumCourse> getAllCurriculumCourses() {
        return curriculumCourseRepository.findAll();
    }

    @GetMapping("/{id}")
    public CurriculumCourse getCurriculumCourseById(@PathVariable int id) {
        return curriculumCourseRepository.findById(id).orElse(null);
    }

    @PostMapping
    public CurriculumCourse addCurriculumCourse(@RequestBody CurriculumCourse curriculumCourse) {
        return curriculumCourseRepository.save(curriculumCourse);
    }

    @PutMapping("/{id}")
    public CurriculumCourse updateCurriculumCourse(@PathVariable int id, @RequestBody CurriculumCourse updatedCurriculumCourse) {
        CurriculumCourse curriculumCourse = curriculumCourseRepository.findById(id).orElse(null);
        if (curriculumCourse != null) {
            // Update properties of existing curriculum course
            curriculumCourse.setCourseCode(updatedCurriculumCourse.getCourseCode());
            curriculumCourse.setStt(updatedCurriculumCourse.getStt());
            curriculumCourse.setCourseName(updatedCurriculumCourse.getCourseName());
            curriculumCourse.setCompanion(updatedCurriculumCourse.getCompanion());
            curriculumCourse.setPrerequisites(updatedCurriculumCourse.getPrerequisites());
            curriculumCourse.setCredits(updatedCurriculumCourse.getCredits());
            curriculumCourse.setLectureHours(updatedCurriculumCourse.getLectureHours());
            curriculumCourse.setLabHours(updatedCurriculumCourse.getLabHours());
            curriculumCourse.setPassStatus(updatedCurriculumCourse.getPassStatus());
            curriculumCourse.setSyllabus(updatedCurriculumCourse.getSyllabus());
            return curriculumCourseRepository.save(curriculumCourse);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCurriculumCourse(@PathVariable int id) {
        curriculumCourseRepository.deleteById(id);
    }
}
