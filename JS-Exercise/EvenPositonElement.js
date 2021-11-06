function slove(numbers) {

    let result = [];
    for (let index = 0; index < numbers.length; index++) {
        if (index % 2 === 0) {
            result.push(numbers[index]);
        }

    }
    console.log(result.join(' '));
}

slove(20);