public class TextStatement extends Statement {
    public String value(Customer aCustomer) {
        String result = "Rental Record for " + aCustomer.getName() + "\n";

        for (Rental each : aCustomer.getRentals()) {
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
}
