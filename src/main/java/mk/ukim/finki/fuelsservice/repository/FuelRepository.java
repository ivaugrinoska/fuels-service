package mk.ukim.finki.fuelsservice.repository;

import mk.ukim.finki.fuelsservice.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long>{

    Fuel findFuelById(Long fuelId);
    void deleteByName(String name);
}
