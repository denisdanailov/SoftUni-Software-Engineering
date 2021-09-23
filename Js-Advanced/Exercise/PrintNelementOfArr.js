function slove(arr, element) {

    let evenArr = [];

    for (let index = 0; index < arr.length; index++) {
       
        if (index % element === 0) {
           evenArr.push(arr[index]);
        }
        
    }
    return evenArr;

}

slove(['5',
    '20',
    '31',
    '4',
    '20'],
    2);