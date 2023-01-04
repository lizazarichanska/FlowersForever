package flower.flowercontinue.flower;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Long> {

    @Query("SELECT f FROM Flower f WHERE f.flowerType = ?1")
    Optional<Flower> findFlowerByType(FlowerType flowerType);
}
