const { expect } = require('chai');
const {isOddOrEven} = require('./EvenOrOdd');

describe('Odd or Even Tests', () => {
    it('it wrong param return undefined',() => {
        expect(isOddOrEven(3)).undefined;
    });

    it('to be return odd' , () => {
       expect(isOddOrEven('hey')).equal('odd');
    });

    it('to be return even' , () => {
        expect(isOddOrEven('hi')).equal('even');
    });

    it('test with multiple strings' , () => {
        expect(isOddOrEven('hey you')).equal('odd');
    });

})