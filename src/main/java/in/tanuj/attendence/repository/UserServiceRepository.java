package in.tanuj.attendence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.tanuj.attendence.entity.UserEntity;

@Repository
public interface UserServiceRepository extends JpaRepository<UserEntity, Integer> {
    
}
