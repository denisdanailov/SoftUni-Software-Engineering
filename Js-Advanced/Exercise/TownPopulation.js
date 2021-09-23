function slove(input) {

    const towns = [];

    for (let data of input) {

        const tokens = data.split(' <-> ');
        const name = tokens[0];
        const pop = Number(tokens[1]);

        if (towns[name] == undefined) {
            towns[name] = pop;
        } else {
            towns[name] += pop;
        }
    }

    for(const name in towns) {
        console.log(`${name} : ${towns[name]}`);
    }

}

slove(['Sofia <-> 1200000',
    'Montana <-> 20000',
    'New York <-> 10000000',
    'Washington <-> 2345000',
    'Las Vegas <-> 1000000']
);