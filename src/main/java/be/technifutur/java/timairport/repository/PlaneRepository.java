package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PlaneRepository extends JpaRepository<Plane, Long> {


    // UPDATE -> sans passer par un select mais directement un set
/*    @Modifying
    @Transactional //utile dans le cas d'un UPDATE/DELETE
    @Query("UPDATE Plane p SET p.inMaintenance =?2 WHERE p.id = ?1")
    void updateMaintenance (long id, boolean maintenance);*/


}
