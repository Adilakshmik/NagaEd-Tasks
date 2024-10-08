package nagaed.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nagaed.com.entity.CourseEntity;
import nagaed.com.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	public CourseEntity saveCourse(CourseEntity entity) {
		CourseEntity courseEntity = courseRepository.save(entity);
		return courseEntity;
	}

	@Override
	public List<CourseEntity> getCourses() {
		List<CourseEntity> courseList = courseRepository.findAll();
		return courseList;
	}

	@Override
	public CourseEntity updateCourse(Integer id,CourseEntity courseEntity) {
		Optional<CourseEntity> byId = courseRepository.findById(id);
		CourseEntity entity = byId.get();
		entity.setDescription(courseEntity.getDescription());
		entity.setDuration(courseEntity.getDuration());
		entity.setTitle(courseEntity.getTitle());
		CourseEntity updatedEntity = courseRepository.save(entity);
		
		return updatedEntity;
	}

	@Override
	public CourseEntity deleteCourse(Integer id,CourseEntity courseEntity) {
		courseRepository.deleteById(id);
		return courseEntity;
	}
	
	

}
