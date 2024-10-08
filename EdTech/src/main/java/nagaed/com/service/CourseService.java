package nagaed.com.service;

import java.util.List;

import nagaed.com.entity.CourseEntity;

public interface CourseService {
	
	public CourseEntity saveCourse(CourseEntity entity);
	public  List<CourseEntity> getCourses();
	public CourseEntity updateCourse(Integer id,CourseEntity entity);
	public CourseEntity deleteCourse(Integer id,CourseEntity entity);

}
