function solve(input) {

    const carBrands = new Map();

    input.forEach((e) => {
        let[brand, model, count] = e.split(' | ');
        count = Number(count);

        if (carBrands.has(brand)) {
            let carBrand = carBrands.get(brand);

            if(carBrand.has(model)) {
                let carModel = carBrand.get(model);
                carModel += count;
                carBrand.set(model,carModel);

            } else {
                    carBrand.set(model,count);
            }

        } else {
            carBrands.set(brand ,new Map());
            carBrands.get(brand).set(model, count);
        }

    });

   for (const key of carBrands.keys()) {
       console.log(key);
       const brand = carBrands.get(key);
       for (const [model, count] of brand) {
           console.log(`###${model} -> ${count}`);
       }
   }
}

solve(['Audi | Q7 | 1000',
    'Audi | Q7 | 200',
    'Bmw | x3 | 2000',
    'Ford | Mustang | 2009',
    'Audi | Q7 | 2000'

]);