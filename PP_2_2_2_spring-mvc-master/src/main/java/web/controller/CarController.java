package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String index(@RequestParam(value = "count", defaultValue = "5", required = false) int count,
                        Model model) {
        if (count < 0) {
            count = 0;
        }
        model.addAttribute("carList", carService.getCarsByCount(count));
        return "cars";
    }
}
