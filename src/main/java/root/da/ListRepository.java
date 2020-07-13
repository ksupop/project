package root.da;


import root.domain.ListEntity;
import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<ListEntity, Long>{

    ListEntity findById(long id);
}