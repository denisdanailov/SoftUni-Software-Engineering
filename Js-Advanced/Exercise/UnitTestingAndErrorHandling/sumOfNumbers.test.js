const { expect } = require('chai');
const {sum} = require('./SumOfNumbers');

 describe('Test Arguments', () => {
    it('works with arguments',() => {
        expect(sum([5,3])).to.equal(8);
    });

    it("it is Arr", () => {


       expect(Array.isArray([1,3,4])).true;
    })
});