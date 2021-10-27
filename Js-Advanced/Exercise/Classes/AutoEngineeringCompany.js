function solve(input) {

    const carBrands = new Map();

    input.forEach((e) => {
        let[brand, model, count] = e.split(' | ');
        count = Number(count);

        if (carBrands.has(brand)) {
            let carBrand = carBrands.get(brand);
            if (carBrand.has(model)) {
                let carModel = carBrand.get(model);
               carModel += count;
               carBrand.push(model, carModel);
            } else {
                carBrand.push(model,count);
            }

        } else {
            carBrands.push(brand, new Map());
        }
    })
}