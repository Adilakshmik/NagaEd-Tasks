package nagaed.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nagaed.com.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>{

}
