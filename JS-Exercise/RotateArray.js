function slove(arr, element) {


    for (let i = 0; i < element; i++) {
        let lastElement = arr.pop();
        arr.unshift(lastElement);

    }
    console.log(arr.join(" "));

}
slove(['Banana', 
'Orange', 
'Coconut', 
'Apple'], 
15
);