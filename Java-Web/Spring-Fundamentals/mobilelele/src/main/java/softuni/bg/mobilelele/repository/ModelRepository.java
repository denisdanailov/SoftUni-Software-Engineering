package softuni.bg.mobilelele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.bg.mobilelele.model.entity.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

}
