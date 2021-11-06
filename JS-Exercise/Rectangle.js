function rectangle(width, height, color) {
   let letter = color.charAt(0).toUpperCase();
   let letter2 = color.substring(1,);
   color = letter + letter2;

    return {
        width,
        height,
        color,
        calcArea: function() {
            return width * height;
        }
    }


}

let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());
