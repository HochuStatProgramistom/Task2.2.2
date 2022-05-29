package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao {

    private static final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Tesla", "White", 1234));
        cars.add(new Car("Bmd", "Red", 2345));
        cars.add(new Car("Audi", "Yellow", 3456));
        cars.add(new Car("Mazda", "White", 4567));
        cars.add(new Car("Toyota", "Blue", 5678));
    }

    @Override
    public List<Car> getCarsByCount(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
