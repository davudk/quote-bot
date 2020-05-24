package util;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextCombinationGenerator {
    private static Pattern pattern = Pattern.compile("([^{]*)\\{(\\d+)}([^{]*)");

    @Test
    public void testGenerator() {
        final List<Combination> combinations = generate(//"Today is a {0} day. There are {1} clouds. It's {2}.",
                many(
                        many("Today is a "),
                        many("nice", "  ok"),
                        many(" day. There are "),
                        many("only a few", "      many"),
                        many(" clouds. Today is "),
                        many("  Friday", "Saturday"),
                        many(".")
                ));

        combinations.forEach(System.out::println);
        System.out.println(combinations.size() + " combinations found.");
    }

    public static <T> List<T> many(Iterable<T> s) {
        final List<T> items = new ArrayList<>();
        for (T t : s) items.add(t);
        return items;
    }

    public static <T> List<T> many(T... s) {
        return Arrays.asList(s);
    }

    public static List<Combination> generate(List<List<String>> args) {
        Objects.requireNonNull(args);

        final List<List<String>> parts = buildArgCombinationsRec(args, 0);

        return parts.stream()
                .map(p -> {
                    final StringBuilder text = new StringBuilder();
                    for (String s : p) {
                        if (s.length() == 0) continue;
                        text.append(s);
                        text.append(" ");
                    }
                    return new Combination(text.toString(), p);
                })
                .collect(Collectors.toList());

//        final List<String> rawParts = new ArrayList<>();
//        final List<List<String>> args = new ArrayList<>();
//        final Matcher m = pattern.matcher(format);
//
//        while (m.find()) {
//            rawParts.add(m.group(1));
//            rawParts.add(m.group(3));
//            final int argNo = Integer.parseInt(m.group(2));
//            args.add(providers.get(argNo).get());
//        }
//
//        final List<List<String>> argCombinations = buildArgCombinationsRec(args, 0);
//        final List<Combination> combinations = new ArrayList<>();
//
//        for (List<String> a : argCombinations) {
//            final StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < a.size(); i++) {
//                sb.append(rawParts.get(i * 2));
//                sb.append(a.get(i));
//                sb.append(rawParts.get(i * 2 + 1));
//            }
//
//            combinations.add(new Combination(format, sb.toString(), a));
//        }
//
//        return combinations;
    }

    private static List<List<String>> buildArgCombinationsRec(
            List<List<String>> args,
            int i) {
        final List<String> curr = args.get(i);
        if (i < args.size() - 1) {
            final List<List<String>> next = buildArgCombinationsRec(args, i + 1);
            final List<List<String>> newCombinations = new ArrayList<>(curr.size() * next.size());
            for (String s : curr) {
                for (List<String> a : next) {
                    final List<String> c = new ArrayList<>(a.size() + 1);
                    c.add(s);
                    c.addAll(a);
                    newCombinations.add(c);
                }
            }
            return newCombinations;
        }

        return curr.stream()
                .map(Collections::singletonList)
                .collect(Collectors.toList());
    }

    public static class Combination {
        private String text;
        private List<String> args;

        public Combination() {}
        public Combination(String text, List<String> args) {
            this.text = text;
            this.args = args;
        }

        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
        public List<String> getArgs() { return args; }
        public void setArgs(List<String> args) { this.args = args; }

        @Override
        public String toString() {
            return text;
        }
    }
}
