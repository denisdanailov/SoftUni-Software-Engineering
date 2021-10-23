const { expect } = require('chai');
const {rgbToHexColor} = require('./RGBtoHex');

describe('RGB Converter', () => {
    it('converts white', () => {
        expect(rgbToHexColor(255,255,255)).to.be.equal('#FFFFFF');
    });

    it('converts black', () => {
        expect(rgbToHexColor(0,0,0)).to.be.equal('#000000');
    });

    it('return undefined', () => {
        expect(rgbToHexColor(1)).to.be.undefined;
    });

    it('return undefined', () => {
        expect(rgbToHexColor(256,255,255)).to.be.undefined;
        expect(rgbToHexColor(255,256,255)).to.be.undefined;
        expect(rgbToHexColor(255,255,256)).to.be.undefined;
        expect(rgbToHexColor(256,256,256)).to.be.undefined;
    });

    it('return undefined', () => {
        expect(rgbToHexColor(-1,-1,-1,)).to.be.undefined;
        expect(rgbToHexColor(1,-1,1,)).to.be.undefined;
        expect(rgbToHexColor(1,1,-1,)).to.be.undefined;
        expect(rgbToHexColor(-1,1,1,)).to.be.undefined;
    });

    it('return undefined', () => {
        expect(rgbToHexColor('255','255','255',)).to.be.undefined;
        expect(rgbToHexColor('255',255,255,)).to.be.undefined;
        expect(rgbToHexColor(255,'255',255,)).to.be.undefined;
        expect(rgbToHexColor(255,255,'255',)).to.be.undefined;
    });

});

