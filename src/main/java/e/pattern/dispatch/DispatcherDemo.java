package e.pattern.dispatch;

import java.util.Random;

/**
 * switch     00:00:00.001295
 * if         00:00:00.000764
 * dispatcher 00:00:00.001154
 */
public class DispatcherDemo {
    private Random random = new Random();
    private Dispatcher dispatcher = new Dispatcher().init();

    public static void main(String[] args) {
        DispatcherDemo demo = new DispatcherDemo();
        Timer timer = new Timer();
        timer.start();
        for (int i = 0; i <= 0xFFFFFF; i++) {
            demo.runSwitch();
        }
        String switchString = timer.stop().toString();
        for (int i = 0; i <= 0xFFFFFF; i++) {
            demo.runIf();
        }
        String ifString = timer.stop().toString();
        for (int i = 0; i <= 0xFFFFFF; i++) {
            demo.runDispatcher();
        }
        String dispatcherString = timer.stop().toString();
        System.out.format("switch     %s%n", switchString);
        System.out.format("if         %s%n", ifString);
        System.out.format("dispatcher %s%n", dispatcherString);
    }

    Value randomValue() {
        return Value.values()[random.nextInt(20)];
    }

    void runSwitch() {
        switch (this.randomValue()) {
            case ZERO:
                fake("zero:");
                break;
            case ONE:
                fake("one:");
                break;
            case TWO:
                fake("two:");
                break;
            case THREE:
                fake("three:");
                break;
            case FOUR:
                fake("four:");
                break;
            case FIVE:
                fake("five:");
                break;
            case SIX:
                fake("six:");
                break;
            case SEVEN:
                fake("seven:");
                break;
            case EIGHT:
                fake("eight:");
                break;
            case NINE:
                fake("nine:");
                break;
            case TEN:
                fake("ten:");
                break;
            case ELEVEN:
                fake("eleven:");
                break;
            case TWELVE:
                fake("twelve:");
                break;
            case THIRTEEN:
                fake("thirteen:");
                break;
            case FOURTEEN:
                fake("fourteen:");
                break;
            case FIFTEEN:
                fake("fifteen:");
                break;
            case SIXTEEN:
                fake("sixteen:");
                break;
            case SEVENTEEN:
                fake("seventeen:");
                break;
            case EIGHTEEN:
                fake("eighteen:");
                break;
            case NINETEEN:
                fake("nineteen:");
                break;
        }
    }

    void runIf() {
        Value value = this.randomValue();
        if (value == Value.ZERO) {
            fake("zero:");
        } else if (value == Value.ONE) {
            fake("one:");
        } else if (value == Value.TWO) {
            fake("two:");
        } else if (value == Value.THREE) {
            fake("three:");
        } else if (value == Value.FOUR) {
            fake("four:");
        } else if (value == Value.FIVE) {
            fake("five:");
        } else if (value == Value.SIX) {
            fake("six:");
        } else if (value == Value.SEVEN) {
            fake("seven:");
        } else if (value == Value.EIGHT) {
            fake("eight:");
        } else if (value == Value.NINE) {
            fake("nine:");
        } else if (value == Value.TEN) {
            fake("ten:");
        } else if (value == Value.ELEVEN) {
            fake("eleven:");
        } else if (value == Value.TWELVE) {
            fake("twelve:");
        } else if (value == Value.THIRTEEN) {
            fake("thirteen:");
        } else if (value == Value.FOURTEEN) {
            fake("fourteen:");
        } else if (value == Value.FIFTEEN) {
            fake("fifteen:");
        } else if (value == Value.SIXTEEN) {
            fake("sixteen:");
        } else if (value == Value.SEVENTEEN) {
            fake("seventeen:");
        } else if (value == Value.EIGHTEEN) {
            fake("eighteen:");
        } else {
            fake("nineteen:");
        }
    }

    void runDispatcher() {
// без учёта инициализации, все времена примерно равны
        this.dispatcher.execute(randomValue());
// с инициализацией выходит много дольше
//        new Dispatcher().init().execute(randomValue());
    }

    private static String s;
    /** Имитация деятельности. Параметр, чтоб было различие в разных
     *  ветках.
     **/
    public static void fake(String s) {
        DispatcherDemo.s = s;
    }
}
