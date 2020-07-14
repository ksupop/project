package root.da;

import root.domain.TaskEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TaskRepository extends CrudRepository<TaskEntity, Long>{

    TaskEntity findById(long id);
    List<TaskEntity> findByParent(Long id);
}