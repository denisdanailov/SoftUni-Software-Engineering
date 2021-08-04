package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    private static final int BASE_EXPERIENCE = 10;

    @Test
    public void shouldReceiveExperienceIFDummyDiesDuringAttack() {
        Axe axe = new Axe(10, 10);
        Dummy target = new Dummy(10, 10);
        Hero hero = new Hero("asd", BASE_EXPERIENCE, axe);

        hero.attack(target);

        assertEquals(BASE_EXPERIENCE + 10, hero.getExperience());
    }
}
