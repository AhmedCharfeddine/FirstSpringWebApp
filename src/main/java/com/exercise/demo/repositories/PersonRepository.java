package com.exercise.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exercise.demo.models.PersonEntity;


public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
    @Query(
        "SELECT p FROM PersonEntity p "  + 
        "WHERE (:fname is null or lower(p.prenom) LIKE LOWER(CONCAT('%', :fname, '%'))) " + 
        "AND (:lname is null or lower(p.nom) like lower(concat('%', :lname, '%'))) " +
        "AND (:civilite = 3 or p.civilite = :civilite)" 
    ) 
    List<PersonEntity> searchQuery(@Param("fname") String fname, @Param("lname") String lname, @Param("civilite") Integer civilite);
}
