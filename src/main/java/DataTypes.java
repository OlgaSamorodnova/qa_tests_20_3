public class DataTypes {
    public static void main(String[] args) {
        System.out.println("Сумма 15 и 12: " + intSum(15,12));
        System.out.println("Сумма - переполнение типа: " + intSum(2000000000,568182740));
        System.out.println("Разница - переполнение типа: " + byteDif(5,135));
        System.out.println("Умножение чисел 5,5 и 3,2: " + floatMult(5.5F, 3.2F));
        System.out.println("Остаток после деления 80 на 41: " + intRestDiv(80,41));
        System.out.println("Деление 7 на 2.5: " + doubleDiv(7,2.5));
        System.out.println("Стоимость взрослого билета в выходной день: " + checkPrice(32,true) + " рублей");
        System.out.println("Стоимость взрослого билета в будний день: " + checkPrice(14,false) + " рублей");
        System.out.println("Стоимость детского билета в выходной день: " + checkPrice(13,true) + " рублей");
        System.out.println("Стоимость билета для малыша в выходной день: " + checkPrice(2,true) + " рублей");
        System.out.println("Стоимость билета для малыша в выходной день: " + checkPrice(2,true) + " рублей");
        System.out.println("Стоимость билета для малыша в будний день: " + checkPrice(0,true) + " рублей");
        System.out.println("Направо пойдешь - " + stonePrediction("направо"));
        System.out.println("Налево пойдешь - " + stonePrediction("налево"));
        System.out.println("Прямо пойдешь - " + stonePrediction("прямо"));
        System.out.println("Назад пойдешь - " + stonePrediction("назад"));


    }
    public static int intSum(int a, int b) {
        return a + b;
    }
    public static byte byteDif(int a, int b) {
        return (byte) (a - b);
    }
    public static float floatMult (float a, float b) {
        return (a * b);
    }
    public static int intRestDiv (int a, int b) {return (a % b);}

    public static double doubleDiv (int a, double b) {
        return a / b;
    }

    //    Цены:
    //    Будни: взрослые - 500, дети (от 3 до 13 включительно) - 400
    //    Выходные: взрослые - 600, дети (от 3 до 13 включительно) - 500
    //    Дети до 3 лет - бесплатно

    public static int checkPrice (int age, boolean isWeekend) {
        if (age>=14 && isWeekend) {
                return (600);
            }
        else if ((age>=14 && !isWeekend)||(age<14 && age>=3 && isWeekend)) {
                return (500);
            }
        else if (age>=3 && !isWeekend) {
            return (400);
        }
        else return (0);
        }

//    «Направо пойдёшь – коня потеряешь, себя спасёшь;
//    налево пойдёшь – себя потеряешь, коня спасёшь;
//    прямо пойдёшь – и себя, и коня потеряешь».
public static String stonePrediction (String direction) {
        String prediction = null;
        switch (direction) {
            case "направо" :
                prediction = "коня потеряешь, себя спасёшь";
                break;
            case "налево" :
                prediction = "себя потеряешь, коня спасёшь";
                break;
            case "прямо" :
                prediction = "и себя, и коня потеряешь";
                break;
            default:
                prediction = "читером назовут";
        }
        return prediction;

}

}

