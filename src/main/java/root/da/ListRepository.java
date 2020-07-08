package root.da;

import org.springframework.data.repository.CrudRepository;
import root.domain.List;

public interface ListRepository extends CrudRepository<List, Long> {
}