package JAZ.lab06.demo.Repositories;

import JAZ.lab06.demo.entities.CalculationParameters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepo extends CrudRepository<CalculationParameters, Long> {
    CalculationParameters findById(long id);
}
