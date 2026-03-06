package in.tanuj.attendence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentServiceRepository extends JpaRepository<StudentEntity, Integer> {
    
}
