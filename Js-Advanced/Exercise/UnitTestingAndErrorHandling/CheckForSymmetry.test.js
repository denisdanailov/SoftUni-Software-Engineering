const { expect } = require('chai');
const {isSymmetric} = require('./CheckForSymmetry');


describe('TestArguments', () => {
    it('work with wrong args be false', () => {
        expect(isSymmetric("text")).false;
    });

    it('return true for symmetric array', () => {
        let arr = [1,2,2,1];
        expect(isSymmetric(arr)).true;
    });

    it('return false for non-symmetric', () => {
        let arr = [1,2,3];
        expect(isSymmetric(arr)).to.be.false;
    });

    it('return false for type-different arg', () => {
        let arr = [1,2,2,'1'];
        expect(isSymmetric(arr)).to.be.false;
    });
})





