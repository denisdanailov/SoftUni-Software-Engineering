package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarSeedDTO;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    public static final String FILE_CARS_PATH = "src/main/resources/files/json/cars.json";
    private final CarRepository carRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    @Autowired
    public CarServiceImpl(CarRepository carRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {

        return Files.readString(Path.of(FILE_CARS_PATH));
    }

    @Override
    public String importCars() throws IOException {

        StringBuilder outputMsg = new StringBuilder();

        Arrays.stream(gson.fromJson(readCarsFileContent(), CarSeedDTO[].class))
                .filter(carSeedDTO -> {
                    boolean isValid = validationUtil.isValid(carSeedDTO);

                    outputMsg.append(isValid
                            ? String.format("Successfully imported car - %s - %s",
                                carSeedDTO.getMake(), carSeedDTO.getModel())
                            : "Invalid car")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(carSeedDTO -> modelMapper.map(carSeedDTO, Car.class))
                .forEach(carRepository::save);

        return outputMsg.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {

        List<Car> cars = this.carRepository.findAllCarsOrderByPictureThanByMake();

        return cars.stream().map(Car::toString)
                .collect(Collectors.joining("\n"));

    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }
}
