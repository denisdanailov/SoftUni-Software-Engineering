function solve(fisrt, second) {
fisrt = Number(fisrt);
second = Number(second);

let lower = Math.min(fisrt, second);
let bigger = Math.max(fisrt, second);
let output = 0;

for(let i = lower; i > 0; i--) {
    if (bigger % i == 0 && lower % i == 0) {
        output = i;
        break
    }
}
console.log(output);
};

solve('5','15');