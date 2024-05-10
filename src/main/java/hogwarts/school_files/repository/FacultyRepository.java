package hogwarts.school_files.repository;

import hogwarts.school_files.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findFacultyByNameContainsIgnoreCase(String name);
    Collection<Faculty> findFacultyByColorContainsIgnoreCase(String color);
}
