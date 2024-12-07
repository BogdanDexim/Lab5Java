import java.util.List;
/**
 * Головний клас для демонстрації роботи з класами Apartment та Appliance.
 */
public class Main {
    public static void main(String[] args) {
        Apartment apartment = new Apartment();
        int my_var = 2108;
        System.out.println("C13= " + my_var % 13);
        // Додавання приладів
        apartment.addAppliance(new KitchenAppliance("Мікрохвильова піч", 800));
        apartment.addAppliance(new CleaningAppliance("Пилосос", 1400));
        apartment.addAppliance(new EntertainmentAppliance("ТБ", 200));
        apartment.addAppliance(new EntertainmentAppliance("Консоль", 100));
        try {
            // Увімкнення приладів
            apartment.plugInAppliance("Мікрохвильова піч");
            apartment.plugInAppliance("ТБ");
            apartment.plugInAppliance("Консоль");
            apartment.plugOutAppliance("Консоль");
            apartment.plugOutAppliance("Посудомийка");
            apartment.plugInAppliance("ТБ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        apartment.printAppliances();
        System.out.println("\nВсього потужності: " + apartment.calculateTotalPower() + "W");

        apartment.sortByPower();
        System.out.println("\nСортування за потужністю:");
        apartment.printAppliances();

        System.out.println("\nПрилади у діапазоні 100-1000W:");
        List<Appliance> rangeAppliances = apartment.findByRadiationRange(100, 1000);
        rangeAppliances.forEach(System.out::println);
    }
}