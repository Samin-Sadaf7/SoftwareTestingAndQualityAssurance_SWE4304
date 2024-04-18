const AutomatedBankFunction = require("../src/AutomatedBank");

describe("BVA_testing/Class", () => {
  describe('Area code at min and others nominal', () => {
    it('Area code is at minimum and other variables are at nominal with command check Status and expected Get Status', () => {
      expect(AutomatedBankFunction(100, 631, 3264, "abc123", "Check Status")).toBe("Get Status");
    });
  });
  describe('Prefix at min and others nominal', () => {
    it('Prefix is at minimum and other variables are at nominal with command withdraw and expected Withdraw Successfully', () => {
      expect(AutomatedBankFunction(531,200,3264,"abc123","Withdraw" )).toBe("Withdrawn Successfully");
    });
  });
  describe('Suffix is at max-1 and others nominal', () => {
    it('Suffix is at maximum -1 and other varibales are at nominal with command deposit and expected Deposit Successfully', () => {
      expect(AutomatedBankFunction(531,631,9998,"abc123","Deposit" )).toBe("Deposited Successfully");
    });
  });
  describe('Password contains a single character and others nominal', () => {
    it('Password contains a single character and others nominal with command Check Status and expected Get Status', () => {
      expect(AutomatedBankFunction(531,631,3264,"99999y","Check Status" )).toBe("Get Status");
    });
  });
  describe('Area code is at max and others at nominal', () => {
    it('Area code is at maximum and other variables are at nominal with command check Status and expected Get Status', () => {
      expect(AutomatedBankFunction(999, 631, 3264, "abc123", "Check Status")).toBe("Get Status");
    });
  });
});
