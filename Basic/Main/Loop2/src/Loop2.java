public class Loop2 {
    public static void execute(){
        //Skapa ett program där användaren får mata in två tal. Låt sedan programmet skriva ut alla
        // tal som finns mellan dessa två tal på skärmen. Lös detta med en for-loop.
        System.out.print("Ange tal 1:"); // 42
        int tal1 = Integer.parseInt(System.console().readLine());
        System.out.print("Ange tal 2:");
        int tal2 = Integer.parseInt(System.console().readLine());
        System.out.println("Talen mellan " + tal1 + " och " +  tal2 +" är");
        // if tal1 > tal2 
        for(int i = tal1+1; i < tal2; i++){
            System.out.println(i);
        }

       
    }
}