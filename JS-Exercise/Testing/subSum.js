function solve(arr, start, end) {

    if (start < 0 ) {
        start = 0;
    }

    if (end > arr.length - 1) {
        end = arr.length - 1;
    }

    sum = 0;

    for(let i = start; i <= end; i++ ) {
        sum += arr[i];
    }

    return console.log(sum);
}

solve([10,20,30,40,50,60], -3, 300);