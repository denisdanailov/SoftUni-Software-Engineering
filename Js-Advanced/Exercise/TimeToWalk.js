function calculate(steps, stepsLength, speed) {

let distanceInMeters = steps * stepsLength;
let speedForMeterInSec = speed / 3.6;

let rest = Math.floor(distanceInMeters / 500);
let time = distanceInMeters / speedForMeterInSec + rest * 60;

let timeInHours = Math.floor(time / 3600);
let timeInMins = Math.floor(time / 60);
let timeInSecs = Math.ceil(time % 60);


console.log(`${timeInHours < 10 ? 0 : ""}${timeInHours}:${timeInMins < 10 ? 0 : ""}${timeInMins}:${timeInSecs < 10 ? 0 : ""}${timeInSecs}`);



}

calculate(2564, 0.70, 5.5);
