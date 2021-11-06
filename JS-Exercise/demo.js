function solution(num) {
    
    return function() {
        this + num;
    };
}
    
let add5 = solution(5);

console.log(add5(2));