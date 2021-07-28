package Reflection_Exercise.barracksWars.core.factories;

import Reflection_Exercise.barracksWars.interfaces.Unit;
import Reflection_Exercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"Reflection_Exercise.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {

		try {
			Class unitClass = unitClass = Class.forName("Reflection_Exercise.barracksWars.models.units." + unitType);
			Constructor<Unit> constructor = unitClass.getConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
