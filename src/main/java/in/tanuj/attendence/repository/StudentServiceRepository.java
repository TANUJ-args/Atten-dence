package in.tanuj.attendence.repository;

import in.tanuj.attendence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentServiceRepository extends JpaRepository<StudentEntity, Integer> {
    
}
