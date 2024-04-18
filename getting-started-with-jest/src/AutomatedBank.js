function AutomatedBankFunction(areaCode, prefix, suffix, password, command) {
    // Validating area code
    var failure = false;
    if (areaCode !== " "){
        if (areaCode < 100 || areaCode > 999) {
            failure = true;
        }
    }   
    // Validating prefix
    if (prefix < 200 || prefix > 999 ) {
        failure = true;
    }
    // Validating suffix
    if (suffix < 1000 || suffix > 9999) {
        failure = true;
    }
    // Validating password
    if (password.length !== 6 || !password.match(/[a-zA-Z]/)|| /^\d+$/.test(password)) {
        failure = true;
    } 
    // Returning appropriate response based on command
    switch (command) {
        case "Check Status":
            if(failure){
                return "Check Status Failed";
            } 
            return "Get Status";
        case "Deposit":
            if(failure){
                return "Failed Deposit";
            }
            return "Deposited Successfully";
        case "Withdraw":
            if(failure){
                return "Withdraw Unsuccessful";
            }
            return "Withdrawn Successfully";
        default:
            return "Failed";
    }
}

module.exports = AutomatedBankFunction;
