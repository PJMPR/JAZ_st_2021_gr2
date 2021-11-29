package JAZ.lab06.demo.Repositories;

import JAZ.lab06.demo.entities.Timetable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimetableRepo extends CrudRepository<Timetable, Long> {
    @Query("select x from Timetable x where x.calculationParameters.id = ?1")
    List<Timetable> findAllById(long id);
}
