package uenp.site.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uenp.site.spring.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
