package mk.ukim.finki.fuelsservice.service;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.fuelsservice.entity.Fuel;
import mk.ukim.finki.fuelsservice.repository.FuelRepository;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class FuelService {

    private final FuelRepository fuelRepository;

    public FuelService(FuelRepository fuelRepository) {
        this.fuelRepository = fuelRepository;
    }

    public Fuel saveFuel(Fuel fuel) {
        log.info("Inside saveFuel method of FuelService");
        return fuelRepository.save(fuel);
    }

    public Fuel findFuelById(Long fuelId) {
        log.info("Inside findFuelById method of FuelService");
        return fuelRepository.findFuelById(fuelId);
    }

    public void deleteById(Long id) {
        this.fuelRepository.deleteById(id);
    }

    public Object addNewFuel(String fuelName, Float fuelLat, Float fuelLong, String imageUrl, String pageLink) {
        if (fuelName.isEmpty())
            return null;

        this.fuelRepository.deleteByName(fuelName);

        return this.fuelRepository.save(new Fuel(fuelName, fuelLat, fuelLong, imageUrl, pageLink));
    }

    public Fuel editFuel(Long id, String fuelName, Float fuelLat, Float fuelLong, String imageUrl, String pageLink) {
        Fuel fuel = this.fuelRepository.findFuelById(id);

        fuel.setName(fuelName);
        fuel.setLatitude(fuelLat);
        fuel.setLongitude(fuelLong);
        fuel.setImageUrl(imageUrl);
        fuel.setPageLink(pageLink);

        return this.fuelRepository.save(fuel);
    }

    public Object findAll() {
        return this.fuelRepository.findAll();
    }
}
