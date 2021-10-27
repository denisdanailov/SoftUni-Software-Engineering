class Rectangle {
    constructor(width, height, color ) {
        this.width = Number(width);
        this.height = Number(height);
        this.color = color;
    }
    calcArea() {
        return this.width * this.height;
    }
}

let rec = new Rectangle(4,5,'Red');
console.log(rec.width);
console.log(rec.height);
console.log(rec.color);
console.log(rec.calcArea());