import java.util.*;
import java.util.stream.Collectors;
/**
 * Клас, що представляє квартиру з електроприладами.
 */
public class Apartment {
    private List<Appliance> appliances;
    /**
     * Конструктор для створення об'єкта Apartment.
     */
    public Apartment() {
        this.appliances = new ArrayList<>();
    }
    /**
     * Додає прилад до списку приладів у квартирі.
     *
     * @param appliance прилад для додавання
     */
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }
    /**
     * Увімкнення приладу в розетку за його назвою.
     *
     * @param name назва приладу
     * @throws NoSuchElementException якщо прилад з вказаною назвою не знайдено
     */
    public void plugInAppliance(String name) {
        appliances.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Прилад не знайдено: " + name))
                .plugIn();
    }
    /**
     * Вимкнення приладу з розетки за його назвою.
     *
     * @param name назва приладу
     * @throws NoSuchElementException якщо прилад з вказаною назвою не знайдено
     */
    public void plugOutAppliance(String name) {
        appliances.stream()
                .filter(a -> a.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Прилад не знайдено: " + name))
                .unplug();
    }
    /**
     * Обчислює загальну споживану потужність увімкнених приладів.
     *
     * @return загальна потужність у ватах
     */
    public int calculateTotalPower() {
        return appliances.stream()
                .filter(Appliance::isPluggedIn)
                .mapToInt(Appliance::getPower)
                .sum();
    }
    /**
     * Сортує список приладів за потужністю.
     */
    public void sortByPower() {
        appliances.sort(Comparator.comparingInt(Appliance::getPower));
    }
    /**
     * Знаходить прилади за вказаним діапазоном потужності.
     *
     * @param minRange мінімальна потужність
     * @param maxRange максимальна потужність
     * @return список приладів у вказаному діапазоні
     */

    public List<Appliance> findByRadiationRange(int minRange, int maxRange) {
        return appliances.stream()
                .filter(a -> a.getPower() >= minRange && a.getPower() <= maxRange)
                .collect(Collectors.toList());
    }
    /**
     * Виводить список всіх приладів у квартирі.
     */
    public void printAppliances() {
        appliances.forEach(System.out::println);
    }
}