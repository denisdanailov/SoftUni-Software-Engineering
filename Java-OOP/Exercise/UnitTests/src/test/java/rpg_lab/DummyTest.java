package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DummyTest {
    private static final int BASE_HEALTH = 10;
    private static final int BASE_EXPERIENCE = 10;
    private Dummy dummy;

    private void setUpAliveDummy() {
        this.dummy = new Dummy(BASE_HEALTH, BASE_EXPERIENCE);
    }

    private void setUpDeadDummy() {
        this.dummy = new Dummy(-BASE_HEALTH, BASE_EXPERIENCE);
    }

    @Test
    public void dummyShouldLoseHealthWhenAttack() {
        final int attack = 5;
        setUpAliveDummy();

        dummy.takeAttack(attack);

     assertEquals(BASE_HEALTH - attack, dummy.getHealth());

    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenAttackingDeadDummy() {
        setUpDeadDummy();

        dummy.takeAttack(5);
    }

    @Test
    public void shouldGiveExperienceIfDead() {
        setUpDeadDummy();

        assertEquals(BASE_EXPERIENCE, dummy.giveExperience());
    }

    @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionWHenGivingExperienceIfAlive() {
        setUpAliveDummy();

        dummy.giveExperience();
    }
}
