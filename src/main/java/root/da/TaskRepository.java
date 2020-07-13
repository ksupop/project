package root.da;

import root.domain.TaskEntity;
import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<TaskEntity, Long>{

    TaskEntity findById(long id);
}