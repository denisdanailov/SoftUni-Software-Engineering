function myFunc(a,b) {
    return a + b + 1;
}

const data = [1,2,3];

function printArr() {
    console.log(data);
}

module.exports = {
    myFunc,
    data,
    printArr,
};