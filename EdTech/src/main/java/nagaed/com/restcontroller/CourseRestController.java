package nagaed.com.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nagaed.com.entity.CourseEntity;
import nagaed.com.service.CourseService;

@RestController
public class CourseRestController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/save")
	public ResponseEntity<CourseEntity> saveCourse(@RequestBody CourseEntity entity){
		CourseEntity savedCourse = courseService.saveCourse(entity);
		return new ResponseEntity<>(savedCourse,HttpStatus.CREATED);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<CourseEntity>> retrieveCourses(){
		List<CourseEntity> courses = courseService.getCourses();
		return new ResponseEntity<>(courses,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<CourseEntity> updateEntity(@RequestBody CourseEntity entity,@PathVariable("id") Integer id){
		CourseEntity updatedCourse = courseService.updateCourse(id, entity);
		return new ResponseEntity<>(updatedCourse,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CourseEntity> deleteEntity(@RequestBody CourseEntity entity,@PathVariable("id") Integer id){
		CourseEntity deletedCourse = courseService.deleteCourse(id, entity);
		return new ResponseEntity<>(deletedCourse,HttpStatus.OK);
	}
	
	

}
