const AutomatedBankFunction = require("../src/AutomatedBank");

describe("WorstCaseBVA_testing/Class", () => {
  describe('Area code at min , prefix at min and others nominal', () => {
    it('Area code is at minimum, prefix at min and other variables are at nominal with command Check Status  and expected Get Status', () => {
      expect(AutomatedBankFunction(100, 200, 3264, "abc123", "Check Status")).toBe("Get Status");
    });
  });
  describe('Area Code is at min, Prefix at max -1  and others nominal', () => {
    it('Area Code is at min, Prefix is at maximum-1 and other variables are at nominal with command Withdraw and expected Withdraw Successfull', () => {
      expect(AutomatedBankFunction(100,998,3264,"abc123","Withdraw" )).toBe("Withdrawn Successfully");
    });
  });
  describe('Area Code  is at min+ 1, Prefix is at min +1, Suffix it at max-1  and Password marginally correct', () => {
    it('Area Code is at min + 1, Prefix is at min +1 , Suffix is at max -1 and other varibales are at nominal with command Deposit and expected Deposited Successfully', () => {
      expect(AutomatedBankFunction(101,201,9998,"99999y","Deposit" )).toBe("Deposited Successfully");
    });
  });
  describe('Area Code is at max, Prefix is at max -1, Suffix is at max and others nominal', () => {
    it('Area Code is at max, Prefix is at max -1, Suffix is at max and others nominal with command Check Status and expected Get Status', () => {
      expect(AutomatedBankFunction(999,998,9999,"abc123","Check Status" )).toBe("Get Status");
    });
  });
  describe('Area Code is at max, Prefix is at max and others at nominal', () => {
    it('Area Code is at maximum, Prefix is at maximum and other variables are at nominal with command Deposit and expected Deposited Successfully', () => {
      expect(AutomatedBankFunction(999, 999, 3264, "abc123", "Deposit")).toBe("Deposited Successfully");
    });
  });
});
