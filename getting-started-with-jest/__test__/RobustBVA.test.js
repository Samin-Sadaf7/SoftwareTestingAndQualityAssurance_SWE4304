const AutomatedBankFunction = require("../src/AutomatedBank");

describe("RobustBVA_testing/Class", () => {
  describe('Area code at min-1 and others nominal', () => {
    it('Area code is at minimum-1 and other variables are at nominal with command check Withdraw and expected Withdraw Unsuccessfull', () => {
      expect(AutomatedBankFunction(99, 631, 3264, "abc123", "Withdraw")).toBe("Withdraw Unsuccessful");
    });
  });
  describe('Prefix at min -1  and others nominal', () => {
    it('Prefix is at minimum -1 and other variables are at nominal with command Deposit and expected Failed Deposit', () => {
      expect(AutomatedBankFunction(513,199,3264,"abc123","Deposit" )).toBe("Failed Deposit");
    });
  });
  describe('Suffix is at min-1 and others nominal', () => {
    it('Suffix is at min -1 and other varibales are at nominal with command Check Status and expected Check Status Failed', () => {
      expect(AutomatedBankFunction(531,631,999,"abc123","Check Status" )).toBe("Check Status Failed");
    });
  });
  describe('Password contains all digits 0', () => {
    it('Password contains all digits 0 and others nominal with command Check Status and expected Check Status Failed', () => {
      expect(AutomatedBankFunction(531,631,3264,"000000","Check Status" )).toBe("Check Status Failed");
    });
  });
  describe('Prefix is at max + 1 and others at nominal', () => {
    it('Prefix is at maximum +1 and other variables are at nominal with command Withdraw and expected Withdraw Unsuccessfull', () => {
      expect(AutomatedBankFunction(513, 1000, 3264, "99999y", "Withdraw")).toBe("Withdraw Unsuccessful");
    });
  });
});
