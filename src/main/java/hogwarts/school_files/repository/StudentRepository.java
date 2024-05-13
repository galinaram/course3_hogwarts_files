package hogwarts.school_files.repository;

import hogwarts.school_files.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(Long min, Long max);
    @Override
    Student getById(Long id);
}
