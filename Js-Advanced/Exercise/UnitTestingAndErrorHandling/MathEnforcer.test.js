let {expect} = require('chai');
let {mathEnforcer} = require('./MathEnforcer');

describe('MathEnforcer Tests',() => {

    it('test addFunction with wrong param', () =>{
       expect(mathEnforcer.addFive('4')).undefined
    });

    it('test addFunction with floating point num', () =>{
        expect(mathEnforcer.addFive(0.01)).to.be.closeTo(5.01,0.001);
    });


    it('test addFunction with negative num', () =>{
        expect(mathEnforcer.addFive(-5)).equal(0);
    });

    it('test addFunction with actually param', () =>{
        expect(mathEnforcer.addFive(5)).equal(10);
    });

    it('test subtractFunc with wrong param', () =>{
        expect(mathEnforcer.subtractTen('4')).undefined
    });

    it('test subtractFunc with actually param', () =>{
        expect(mathEnforcer.subtractTen(20)).equal(10);
    });

    it('test subtractFunc with negative num', () =>{
        expect(mathEnforcer.subtractTen(-10)).equal(-20);
    });

    it('test subtractFunc with floating point num', () =>{
        expect(mathEnforcer.subtractTen(10.005)).to.be.closeTo(0.005000000000000782,0.001);
    });

    it('test sumFun with wrong param', () =>{
        expect(mathEnforcer.sum('4',5)).undefined
    });

    it('test sumFun with wrong param2', () =>{
        expect(mathEnforcer.sum(4,'5')).undefined
    });

    it('test sumFunc with actually param', () =>{
        expect(mathEnforcer.sum(20,20)).equal(40);
    });

    it('test sumFunc with negative num', () =>{
        expect(mathEnforcer.sum(-2,20)).equal(18);
    });

    it('test sumFunc with floating point num', () =>{
        expect(mathEnforcer.sum(0.002,0.66)).to.be.closeTo(0.662,0.001);
    });
});