package com.persteenolsen.springbootmvcjspjpa;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.persteenolsen.springbootmvcjspjpa.PersonEntity;
 
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
 
}