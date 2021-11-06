function city(name, population, treasury) {

   
    const result = {
        name,
        population,
        treasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += Math.floor(this.population * this.taxRate);
        },
        applyGrowth(precent) {
            this.population += Math.floor(this.population * (precent / 100));
        },
        applyRecession(precent) {
            this.treasury -= Math.ceil(this.treasury * (precent / 100));
        },
    }

    return result;
    
    }

    const tortuga = city('Tortuga', 7000, 15000);
    