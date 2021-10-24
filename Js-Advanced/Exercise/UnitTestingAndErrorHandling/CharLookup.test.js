const {expect} = require('chai');
const {lookupChar} = require('./CharLookup');

describe('Arg Test',() => {

    it('wrong string argument return undefined', () =>{
        expect(lookupChar(1,2)).undefined;
    })

    it('wrong integer argument return undefined', () =>{
        expect(lookupChar('string','string2')).undefined;
    })

    it('test with Incorrect index', () =>{
        expect(lookupChar('string',100)).equal('Incorrect index');
    })

    it('test with negative index', () =>{
        expect(lookupChar('string',-1)).equal('Incorrect index');
    })

    it('test with floating number', () =>{
        expect(lookupChar('string',2.5)).undefined
    })

    it('test with actually args', () =>{
        expect(lookupChar('test',2)).equal('s');
    })


});