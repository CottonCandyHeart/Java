import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String exit;
        String s;
        Kalkulator k;
        int chooseType;
        int chooseConstant;

        do {

            System.out.println("1. Operation\n2. Mathematical Constant");
            chooseType = Integer.parseInt(scanner.nextLine());

            if (chooseType == 1){
                System.out.println("Operation: ");
                s = scanner.nextLine();

                k = new Kalkulator(s);
                k.getResult();
                k.printResult();

            }else if(chooseType == 2){
                k = new Kalkulator();
                chooseConstant = Integer.parseInt(scanner.nextLine());
                System.out.println(k.getMathConst(chooseConstant));
            }

            System.out.println("Do you want to exit? (y/n)");
            exit = scanner.nextLine().toLowerCase();

        } while (!exit.equals("y") && !exit.equals("yes"));


    }


}