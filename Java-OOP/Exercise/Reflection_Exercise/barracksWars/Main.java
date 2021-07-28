package Reflection_Exercise.barracksWars;

import Reflection_Exercise.barracksWars.interfaces.Repository;
import Reflection_Exercise.barracksWars.interfaces.Runnable;
import Reflection_Exercise.barracksWars.interfaces.UnitFactory;
import Reflection_Exercise.barracksWars.core.Engine;
import Reflection_Exercise.barracksWars.core.factories.UnitFactoryImpl;
import Reflection_Exercise.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
