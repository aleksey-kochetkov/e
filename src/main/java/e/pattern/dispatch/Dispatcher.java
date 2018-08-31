package e.pattern.dispatch;

import java.util.Map;
import java.util.HashMap;

public class Dispatcher {
    private Map<Value, Command> map = new HashMap<>();

    public Dispatcher init() {
        this.map.put(Value.ZERO, () -> DispatcherDemo.fake("zero:"));
        this.map.put(Value.ONE, () -> DispatcherDemo.fake("one:"));
        this.map.put(Value.TWO, () -> DispatcherDemo.fake("two:"));
        this.map.put(Value.THREE, () -> DispatcherDemo.fake("three:"));
        this.map.put(Value.FOUR, () -> DispatcherDemo.fake("four:"));
        this.map.put(Value.FIVE, () -> DispatcherDemo.fake("five:"));
        this.map.put(Value.SIX, () -> DispatcherDemo.fake("six:"));
        this.map.put(Value.SEVEN, () -> DispatcherDemo.fake("seven:"));
        this.map.put(Value.EIGHT, () -> DispatcherDemo.fake("eight:"));
        this.map.put(Value.NINE, () -> DispatcherDemo.fake("nine:"));
        this.map.put(Value.TEN, () -> DispatcherDemo.fake("ten:"));
        this.map.put(Value.ELEVEN, () -> DispatcherDemo.fake("eleven:"));
        this.map.put(Value.TWELVE, () -> DispatcherDemo.fake("twelve:"));
        this.map.put(Value.THIRTEEN, () -> DispatcherDemo.fake("thirteen:"));
        this.map.put(Value.FOURTEEN, () -> DispatcherDemo.fake("fourteen:"));
        this.map.put(Value.FIFTEEN, () -> DispatcherDemo.fake("fifteen:"));
        this.map.put(Value.SIXTEEN, () -> DispatcherDemo.fake("sixteen:"));
        this.map.put(Value.SEVENTEEN, () -> DispatcherDemo.fake("seventeen:"));
        this.map.put(Value.EIGHTEEN, () -> DispatcherDemo.fake("eighteen:"));
        this.map.put(Value.NINETEEN, () -> DispatcherDemo.fake("nineteen:"));
        return this;
    }

    public void execute(Value value) {
        this.map.get(value).execute();
    }
}
