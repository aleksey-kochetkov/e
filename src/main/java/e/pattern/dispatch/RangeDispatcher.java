package e.pattern.dispatch;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public class RangeDispatcher {
    private Map<Predicate<Integer>, Command> map = new LinkedHashMap<>();

    public RangeDispatcher init() {
        this.map.put(i -> i < 10, () -> RangeDispatcherDemo.fake("zero:"));
        this.map.put(i -> i < 20, () -> RangeDispatcherDemo.fake("one:"));
        this.map.put(i -> i < 30, () -> RangeDispatcherDemo.fake("two:"));
        this.map.put(i -> i < 40, () -> RangeDispatcherDemo.fake("three:"));
        this.map.put(i -> i < 50, () -> RangeDispatcherDemo.fake("four:"));
        this.map.put(i -> i < 60, () -> RangeDispatcherDemo.fake("five:"));
        this.map.put(i -> i < 70, () -> RangeDispatcherDemo.fake("six:"));
        this.map.put(i -> i < 80, () -> RangeDispatcherDemo.fake("seven:"));
        this.map.put(i -> i < 90, () -> RangeDispatcherDemo.fake("eight:"));
        this.map.put(i -> i < 100, () -> RangeDispatcherDemo.fake("nine:"));
        this.map.put(i -> i < 110, () -> RangeDispatcherDemo.fake("ten:"));
        this.map.put(i -> i < 120, () -> RangeDispatcherDemo.fake("eleven:"));
        this.map.put(i -> i < 130, () -> RangeDispatcherDemo.fake("twelve:"));
        this.map.put(i -> i < 140, () -> RangeDispatcherDemo.fake("thirteen:"));
        this.map.put(i -> i < 150, () -> RangeDispatcherDemo.fake("fourteen:"));
        this.map.put(i -> i < 160, () -> RangeDispatcherDemo.fake("fifteen:"));
        this.map.put(i -> i < 170, () -> RangeDispatcherDemo.fake("sixteen:"));
        this.map.put(i -> i < 180, () -> RangeDispatcherDemo.fake("seventeen:"));
        this.map.put(i -> i < 190, () -> RangeDispatcherDemo.fake("eighteen:"));
        this.map.put(i -> true, () -> RangeDispatcherDemo.fake("nineteen:"));
        return this;
    }

    public void execute(Integer value) {
        for (Map.Entry<Predicate<Integer>, Command> e
                                                 : this.map.entrySet()) {
            if (e.getKey().test(value)) {
                e.getValue().execute();
                break;
            }
        }
// так на 10% больше время
//        for (Predicate<Integer> k : this.map.keySet()) {
//            if (k.test(value)) {
//                this.map.get(k).execute();
//                break;
//            }
//        }
    }
}
