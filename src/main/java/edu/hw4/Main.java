package edu.hw4;

import edu.hw4.Animal.Sex;
import edu.hw4.Animal.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        @SuppressWarnings("MagicNumber")
        var animals = new ArrayList<Animal>() {{
            add(new Animal("", Type.CAT, Sex.F, 5, 20, 4, true));
            add(new Animal("Margarita", Type.CAT, Sex.M, 10, 20, 4, true));
            add(new Animal("rex", Type.DOG, Sex.M, 6, 30, 15, true));
            add(new Animal("Goldfish", Type.FISH, Sex.M, 5, 5, 2, false));
            add(new Animal("Сrow", Type.BIRD, Sex.F, 3, 10, 3, false));
            add(new Animal("Pauk", Type.SPIDER, Sex.M, 1, 2, 1, true));
            add(new Animal("Paukan", Type.SPIDER, Sex.F, 2, 3, 1, true));
        }};
    }

    static List<Animal> task1(List<Animal> animalList) {
        return animalList
            .stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(toList());
    }

    static List<Animal> task2(List<Animal> animalList, int k) {
        return animalList
            .stream()
            .sorted((a1, a2) -> Integer.compare(a2.weight(), a1.weight()))
            .limit(k)
            .collect(toList());
    }

    static Map<Type, Integer> task3(List<Animal> animalList) {
        return animalList
            .stream()
            .collect(Collectors.groupingBy(Animal::type, summingInt(a -> 1)));
    }

    static Animal task4(List<Animal> animalList) {
        return animalList
            .stream()
            .max(Comparator.comparing(a -> a.name().length()))
            .orElse(null);
    }

    static Sex task5(List<Animal> animalList) {
        var freqMap = animalList
            .stream()
            .collect(groupingBy(Animal::sex, Collectors.counting()));
        return freqMap.get(Sex.M) > freqMap.get(Sex.F) ? Sex.M : Sex.F;
    }

    static Map<Animal.Type, Animal> task6(List<Animal> animalList) {
        return animalList
            .stream()
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    static Animal task7(List<Animal> animalList, int k) {
        return animalList
            .stream()
            .sorted((a1, a2) -> a2.age() - a1.age())
            .skip(k - 1)
            .toList()
            .getFirst();
    }

    static Optional<Animal> task8(List<Animal> animalList, int k) {
        return animalList
            .stream()
            .filter(a -> a.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    static Integer task9(List<Animal> animalList) {
        AtomicInteger pawsCount = new AtomicInteger();
        animalList
            .stream()
            .forEach(a -> pawsCount.addAndGet(a.paws()));
        return pawsCount.get();
    }

    static List<Animal> task10(List<Animal> animalList) {
        return animalList
            .stream()
            .filter(a -> a.age() != a.paws())
            .toList();
    }

    @SuppressWarnings("MagicNumber")
    static List<Animal> task11(List<Animal> animalList) {
        return animalList
            .stream()
            .filter(a -> a.bites() && a.height() > 100)
            .toList();
    }

    static Integer task12(List<Animal> animalList) {
        AtomicInteger count = new AtomicInteger();
        animalList
            .stream()
            .forEach(a -> {
                if (a.weight() > a.height()) {
                    count.incrementAndGet();
                }
            });
        return count.get();
    }

    static List<Animal> task13(List<Animal> animalList) {
        return animalList
            .stream()
            .filter(a -> a.name().split(" ").length == 2)
            .collect(toList());
    }

    static Boolean task14(List<Animal> animalList, int k) {
        return animalList
            .stream()
            .anyMatch(a -> a.type() == Type.DOG && a.height() > k);
    }

    static Map<Animal.Type, Integer> task15(List<Animal> animalList, int k, int l) {
        return animalList
            .stream()
            .filter(a -> k <= a.age() && a.age() <= l)
            .collect(groupingBy(Animal::type, summingInt(Animal::weight)));
    }

    static List<Animal> task16(List<Animal> animalList) {
        return animalList
            .stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name))
            .collect(toList());
    }

    static Boolean task17(List<Animal> animalList) {
        return animalList
            .stream()
            .filter(a -> a.type() == Type.DOG || a.type() == Type.SPIDER)
            .collect(groupingBy(Animal::type, summingInt((a) -> a.bites() ? 1 : -1)))
            .entrySet().stream()
            .reduce((a, b) -> a.getValue() < b.getValue() ? a : b).get().getKey() == Type.SPIDER;
    }

    static Animal task18(List<Animal> animalList1, List<Animal> animalList2) {
        return Stream.concat(animalList1.stream(), animalList2.stream())
            .min(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    static Map<String, Set<ValidationError>> task19(List<Animal> animalList) {
        return animalList.stream()
            .filter(a -> !ValidationError.validateName(a.name()).isEmpty())
            .collect(groupingBy(
                Animal::name,
                flatMapping(a -> ValidationError.validateName(a.name()).stream(), Collectors.toSet())
            ));
    }
}

