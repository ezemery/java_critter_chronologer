package com.udacity.jdnd.course3.critter.repository;
import com.udacity.jdnd.course3.critter.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("from Pet p join fetch p.owner c" +
            " where c.id = :id")
    List<Pet> findPetByCustomerId(@Param("id") long id);
}
