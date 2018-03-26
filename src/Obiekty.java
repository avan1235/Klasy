import java.util.Scanner;

/**
 * Maciej Procyk 22.03.2018
 */
public class Obiekty {

    public static void main(String[] args){

        Scanner inputKeyboard = new Scanner(System.in);
        Employer pracownik = new Employer("Rafał", 3, 4);
        System.out.println(pracownik.showName() + " pracuje " + pracownik.showYearsWorking() + " lat.");
        System.out.println("Jego doswiadczenie to " + pracownik.showSkills());
        int addSkils = (int)(100*Math.random());
        System.out.println("Zwiększam doswiadczenie o " + addSkils);
        pracownik.raiseSkill(addSkils);
        System.out.println("Jego aktualne doswiadcznenie to " + pracownik.showSkills());

        Employer pracownik2 = new Employer("Staszek", 2500);
        System.out.println();
        System.out.println("Pracownik " + pracownik2.showName() + " zarabia aktualnie " + pracownik2.showSalary() + " zl");
        System.out.print("Jaka podwyzka: ");
        int moreMoney = inputKeyboard.nextInt();
        pracownik2.giveMoreMoney(moreMoney);
        System.out.println("Pracownik " + pracownik2.showName() + " zarabia aktualnie " + pracownik2.showSalary() + " zl");

        Employer pracownik3 = new Employer("Rafał", 2300);
        System.out.print(pracownik.showName() + " i " + pracownik3.showName());
        if (pracownik3.hasTheSameName(pracownik)){
            System.out.println(" to te same imiona");
        }
        else{
            System.out.println(" to inne imiona");
        }

        pracownik.giveID();
        pracownik2.giveID();
        pracownik3.giveID();

        System.out.println(pracownik.showName() + " ma ID " + pracownik.showID());
        System.out.println(pracownik2.showName() + " ma ID " + pracownik2.showID());
    }
}

class Employer{
    /**
     * Pola statyczne są dostępne przez wszystkic przedstawicieli danej klasy
     * tworzac zmienna private static nextID = 1 oraz public id
     * i zapisując id = nextID a nastepnie dla innego pracownika nextID++ i
     * id = nextID, jgo id = 2
     *
     */
    private final String name;
    private int yearsWorking;
    private int skill;
    private int salary;

    private static int nextID = 1;
    private int itsID;

    public Employer(String thisName, int thisYearWorking, int thisSkill){ // Konstruktor obiektu
        name = thisName;
        yearsWorking = thisYearWorking;
        skill = thisSkill;
    }

    public Employer(String thisName, int thisSalary){
        this.salary = thisSalary;
        this.name = thisName;
    }

    public String showName(){
        return name;
    }

    public int showYearsWorking(){
        return yearsWorking;
    }

    public int showSkills(){
        return skill;
    }

    public int showSalary(){
        return this.salary;
    }

    public void raiseSkill(int howManyPointsAdd){
        skill += howManyPointsAdd;
    }

    public void giveMoreMoney (int howMuchAdd){
        this.salary += howMuchAdd;
    }

    public boolean hasTheSameName(Employer namer){
        return this.name.equalsIgnoreCase(namer.name);
    }

    public void giveID(){
        this.itsID = nextID;
        Employer.nextID++;
    }

    public int showID(){
        return this.itsID;
    }
}
