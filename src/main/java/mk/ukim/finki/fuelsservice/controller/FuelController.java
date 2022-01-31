package mk.ukim.finki.fuelsservice.controller;

import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.fuelsservice.entity.Fuel;
import mk.ukim.finki.fuelsservice.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/fuels")
@Slf4j
public class FuelController {

    @Autowired
    private FuelService fuelService;

    @PostMapping("/")
    public Fuel saveFuel(@RequestBody Fuel fuel){
        log.info("Inside saveFuel method of FuelController");
        return fuelService.saveFuel(fuel);
    }

    @GetMapping("/{id}")
    public Fuel findFuelById(@PathVariable("id") Long fuelId){
        log.info("Inside findFuelById method of FuelController");
        return fuelService.findFuelById(fuelId);
    }

    @GetMapping
    public String getShowAndAddFuelPage(@RequestParam(required = false) String error, Model model){

        if(error != null && error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("showAllFuels", this.fuelService.findAll());

        return "showAllFuels";
    }

    @GetMapping("/addNewFuel")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addNewFuel(){

        return "addNewFuel";
    }

    @PostMapping("/add-fuel")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addFuel(@RequestParam(required = false) Long id, HttpServletRequest request){

        String fuelName = request.getParameter("fuelName");
        Float fuelLat = Float.parseFloat(request.getParameter("fuelLat"));
        Float fuelLong = Float.parseFloat(request.getParameter("fuelLong"));
        String imageUrl = request.getParameter("imageUrl");
        String pageLink = request.getParameter("pageLink");

        if(id != null){
            this.fuelService.editFuel(id, fuelName, fuelLat, fuelLong, imageUrl, pageLink);
        }
        else {
            this.fuelService.addNewFuel(fuelName, fuelLat, fuelLong, imageUrl, pageLink);
        }

        return "redirect:/showAndAddFuel";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFuel(@PathVariable Long id){

        this.fuelService.deleteById(id);
        return "redirect:/showAndAddFuel";
    }

}
