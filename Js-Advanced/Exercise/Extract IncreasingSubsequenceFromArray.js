function slove(input) {

    let max = Number.MIN_SAFE_INTEGER;
    let arr = [];

    input.forEach(num => {

        if (num > max) {
            max = num;
            arr.push(max);
        }
    });


    return arr;
}

slove([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24]
)