function solve() {
    let fighter = (name) => {
        return {

            name,
            health: 100,
            stamina: 100,
            fight() {
                this.stamina -=1;
                console.log(`${name} slashes at the foe!`);
            }
        }
    }

    let mage = (name) => {
        return {
            name,
            health: 100,
            mana: 100,
            cast(spellName) {
                this.mana -= 1;
                console.log(`${name} cast ${spellName}`);
            }
        }
    }

    return {fighter: fighter, mage: mage};
}