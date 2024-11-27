import java.util.ArrayList;

public class Customer {
   private String _name;
   private ArrayList<Rental> _rentals = new ArrayList<>();

   public Customer(String name) {
      _name = name;
   }

   public void addRental(Rental rental) {
      _rentals.add(rental);
   }

   public String getName() {
      return _name;
   }

   public ArrayList<Rental> getRentals() {
      return _rentals;
   }

   public double getTotalCharge() {
      double result = 0;
      for (Rental rental : _rentals) {
         result += rental.getCharge();
      }
      return result;
   }

   public int getTotalFrequentRenterPoints() {
      int result = 0;
      for (Rental rental : _rentals) {
         result += rental.getFrequentRenterPoints();
      }
      return result;
   }

   public String statement() {
      return new TextStatement().value(this);
   }

   public String htmlStatement() {
      return new HtmlStatement().value(this);
   }
}
