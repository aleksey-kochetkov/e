package e.pattern.dispatch;

import java.util.Random;

/** switch     00:00:00.000671
 *  if         00:00:00.000655
 *  dispatcher 00:00:00.003385
 */
public class RangeDispatcherDemo {
    private Random random = new Random();
    private RangeDispatcher dispatcher = new RangeDispatcher().init();

    public static void main(String[] args) {
        RangeDispatcherDemo demo = new RangeDispatcherDemo();
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

    int randomValue() {
        return random.nextInt(200);
    }

    void runSwitch() {
        switch (this.randomValue()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                fake("zero:");
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                fake("one:");
                break;
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                fake("two:");
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                fake("three:");
                break;
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                fake("four:");
                break;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                fake("five:");
                break;
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                fake("six:");
                break;
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
                fake("seven:");
                break;
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
                fake("eight:");
                break;
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
                fake("nine:");
                break;
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                fake("ten:");
                break;
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
                fake("eleven:");
                break;
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
                fake("twelve:");
                break;
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
                fake("thirteen:");
                break;
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
                fake("fourteen:");
                break;
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                fake("fifteen:");
                break;
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
                fake("sixteen:");
                break;
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 178:
            case 179:
                fake("seventeen:");
                break;
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
                fake("eighteen:");
                break;
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case 198:
            case 199:
                fake("nineteen:");
                break;
        }
    }

    void runIf() {
        int value = this.randomValue();
        if (value < 10) {
            fake("zero:");
        } else if (value < 20) {
            fake("one:");
        } else if (value < 30) {
            fake("two:");
        } else if (value < 40) {
            fake("three:");
        } else if (value < 50) {
            fake("four:");
        } else if (value < 60) {
            fake("five:");
        } else if (value < 70) {
            fake("six:");
        } else if (value < 80) {
            fake("seven:");
        } else if (value < 90) {
            fake("eight:");
        } else if (value < 100) {
            fake("nine:");
        } else if (value < 110) {
            fake("ten:");
        } else if (value < 120) {
            fake("eleven:");
        } else if (value < 130) {
            fake("twelve:");
        } else if (value < 140) {
            fake("thirteen:");
        } else if (value < 150) {
            fake("fourteen:");
        } else if (value < 160) {
            fake("fifteen:");
        } else if (value < 170) {
            fake("sixteen:");
        } else if (value < 180) {
            fake("seventeen:");
        } else if (value < 190) {
            fake("eighteen:");
        } else {
            fake("nineteen:");
        }
    }

    void runDispatcher() {
// без учёта инициализации
        this.dispatcher.execute(randomValue());
// с инициализацией
//        new RangeDispatcher().init().execute(randomValue());
    }

    private static String s;
    /** Имитация деятельности. Параметр, чтоб было различие в разных
     *  ветках.
     **/
    public static void fake(String s) {
        RangeDispatcherDemo.s = s;
    }
}
