class List {
    constructor() {
        this.numbers = [];
        this.size = 0;
    }

    add(value) {
        this.numbers.push(value);
        this.numbers.sort((a, b) => a - b);
        this.size++;
    }

    remove(index) {

        this.outOfBoundCheck(index);
        this.numbers.splice(index, 1);
        this.size--;
    }

    get(index) {
        this.outOfBoundCheck(index);
        return this.numbers[index];
    }

    outOfBoundCheck(index) {
        if (index < 0 || index >= this.numbers.length) {
            throw new Error("No such index in List")
        }
    }
}


let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));

