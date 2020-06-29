package root.da;

import org.springframework.data.repository.CrudRepository;
import root.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}