package pl.dmcs.rkotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.dmcs.rkotas.model.Student;

@Repository
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public interface StudentRepository extends JpaRepository<Student, Long> {
}
