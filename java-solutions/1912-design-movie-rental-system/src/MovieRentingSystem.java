import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sichu huang
 * @since 2025/09/21 15:03
 */
public class MovieRentingSystem {

    private final Map<Pair, Integer> tPrice = new HashMap<>();
    private final Map<Integer, TreeSet<Pair>> tValid = new HashMap<>();
    private final TreeSet<Triple> tRent = new TreeSet<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] entry : entries) {
            Pair p = new Pair(entry[0], entry[1]);
            tPrice.put(p, entry[2]);
            tValid.computeIfAbsent(entry[1], k -> new TreeSet<>(
                (a, b) -> a.first != b.first ? Integer.compare(a.first, b.first) :
                    Integer.compare(a.second, b.second))).add(new Pair(entry[2], entry[0]));
        }
    }

    public List<Integer> search(int movie) {
        if (!tValid.containsKey(movie)) {
            return Collections.emptyList();
        }
        return tValid.get(movie).stream().limit(5).map(p -> p.second).collect(Collectors.toList());
    }

    public void rent(int shop, int movie) {
        int price = tPrice.get(new Pair(shop, movie));
        tValid.get(movie).remove(new Pair(price, shop));
        tRent.add(new Triple(price, shop, movie));
    }

    public void drop(int shop, int movie) {
        int price = tPrice.get(new Pair(shop, movie));
        tValid.get(movie).add(new Pair(price, shop));
        tRent.remove(new Triple(price, shop, movie));
    }

    public List<List<Integer>> report() {
        return tRent.stream().limit(5).map(t -> Arrays.asList(t.shop, t.movie))
            .collect(Collectors.toList());
    }
}

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair)o;
        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        return (first << 16) ^ second;
    }
}

class Triple implements Comparable<Triple> {
    int price, shop, movie;

    Triple(int price, int shop, int movie) {
        this.price = price;
        this.shop = shop;
        this.movie = movie;
    }

    @Override
    public int compareTo(Triple o) {
        if (price != o.price) {
            return Integer.compare(price, o.price);
        }
        if (shop != o.shop) {
            return Integer.compare(shop, o.shop);
        }
        return Integer.compare(movie, o.movie);
    }
}