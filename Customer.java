import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<>();  // Usando List no lugar de Vector

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);  // Usando add() no lugar de addElement()
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Iterator<Rental> rentals = _rentals.iterator();  // Usando Iterator
        String result = "Rental Record for " + getName() + "\n";
        
        while (rentals.hasNext()) {
            Rental each = rentals.next();  // Usando next() para acessar o próximo elemento
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        Iterator<Rental> rentals = _rentals.iterator();  // Usando Iterator
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        
        while (rentals.hasNext()) {
            Rental each = rentals.next();
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) +
                 "</EM> frequent renter points<P>";
        
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Iterator<Rental> rentals = _rentals.iterator();  // Usando Iterator
        while (rentals.hasNext()) {
            Rental each = rentals.next();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Iterator<Rental> rentals = _rentals.iterator();  // Usando Iterator
        while (rentals.hasNext()) {
            Rental each = rentals.next();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
