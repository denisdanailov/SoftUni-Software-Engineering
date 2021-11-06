const { expect } = require('chai');
const {myFunc} = require('./demo');

describe.only('Demo-test', () => {
    it('works with 5 and 3',() => {
      expect(myFunc(5,3)).to.equal(8);
    });
});

