public class Customer {
    private String _name;
    @SuppressWarnings("rawtypes")
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    @SuppressWarnings("unchecked")
    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    @SuppressWarnings("rawtypes")
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        
        // Iterando sobre os aluguéis do cliente
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // Chama o método getFrequentRenterPoints() de Rental
            frequentRenterPoints += each.getFrequentRenterPoints(); // Substitui a lógica anterior

            // Show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge(); // Usando diretamente o método getCharge() em vez de 'thisAmount'
        }

        // Add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
