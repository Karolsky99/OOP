import java.util.*;
interface Executive {
    void myPower();
    void manage();
}
abstract class Ministry implements Executive {
    public void myPower() {
        System.out.println("We manage part of the country");
    }
    abstract public void manage();
}
class MinistryOfHealth extends Ministry { // polymorphism - access to the same method in parent class and adding new ones
    public void myPower() {
        System.out.println("We manage health care system");
    }
    public void manage() {
        System.out.println("Buy more masks for hospitals!");
    }
}
class MinistryOfFinance extends Ministry { // inheritance - to reuse attributes and methods of an existing class when you create a new class
    public void myPower() {
        System.out.println("We manage financial system");
    }
    public void manage() {
        System.out.println("We need more money!");
    }
}
interface Legislative {
    void vote(int votes);
}
abstract class Parliament implements Legislative { // abstract - to hide certain details and only show the important details of an object.
    abstract public void vote(int votes);
    protected void deepAnalysis(){
        System.out.println("Hmm...");
    }
    protected void amendmentMaking(){
        System.out.println("Change something!");
    }
    protected void loudApplause(){
        System.out.println("Clap, clap!");
    }
    protected void loudHumming(){
        System.out.println("Boo, boo!");
    }
    protected void announcement(float result){
        if (result >= 0.5) {
            loudApplause();
            System.out.println("We passed the act");
        } else {
            loudHumming();
            System.out.println("We did not pass the act");
        }
    }

}
class Sejm extends Parliament {
    int number = 460;
    public void vote(int votes){
        float result = (float)votes/number;
        deepAnalysis();
        amendmentMaking();
        announcement(result);
    }
}
class Posel extends Sejm {
    private String politicalAffiliation = "non-party";
    public void getAffiliation() { // Encapsulation - access to private fields or methods
        System.out.println(politicalAffiliation);
    }
    public void setAffiliation(String newParty) {
        this.politicalAffiliation = newParty;
    }
}
class Senat extends Parliament {
    int number = 100;
    public void vote(int votes){
        float result = (float)votes/number;
        deepAnalysis();
        amendmentMaking();
        if (result >= 0.5) {
            loudApplause();
            System.out.println("We passed the act");
        } else {
            loudHumming();
            System.out.println("We did not pass the act");
        }
    }
}
class Senator extends Senat {
    private String politicalAffiliation = "non-party";
    public void getAffiliation() {
        System.out.println(politicalAffiliation);
    }
    public void setAffiliation(String newParty) {
        this.politicalAffiliation = newParty;
    }
}
interface Judicial {
    void myPower();
    void judgement(String defendant, String charge);


}

abstract class CommonCourt implements Judicial { // polymorphism -
    public void myPower(){
        System.out.println("We can sentence common people to prison");
    }
    public abstract void judgement(String defendant, String charge);
}

abstract class MilitaryCourt implements Judicial {
    public void myPower(){
        System.out.println("We can sentence soldiers to prison");
    }
    public abstract void judgement(String defendant, String charge);
}

class CommonJudge extends CommonCourt {
    public void myPower(){
        System.out.println("I can sentence common people to prison");
    }
    public void judgement(String defendant, String charge) {
        int lengthOfSentence;
        switch (charge) {
            case "theft":
                lengthOfSentence = 1;
                break;
            case "robbery":
                lengthOfSentence = 3;
                break;
            case "murder":
                lengthOfSentence = 25;
                break;
            default:
                lengthOfSentence = 0;
        }
        System.out.println("I sentence " + defendant + " to " + lengthOfSentence + " years in prison");
    }
}
class FirstInstance extends CommonJudge { // polymorphism - access to the same judgement method in parent class and adding new fields
    int priority = 1;
}
class SecondInstance extends CommonJudge {
    int priority = 2;
}
class ThirdInstance extends CommonJudge {
    int priority = 3;
}
class MilitaryJudge extends MilitaryCourt {
    public void myPower(){
        System.out.println("I can sentence soldiers to prison");
    }
    public void judgement(String defendant, String charge) {
        int lengthOfSentence;
        switch (charge) {
            case "theft of weapons":
                lengthOfSentence = 5;
                break;
            case "disobeying an order":
                lengthOfSentence = 10;
                break;
            case "murder":
                lengthOfSentence = 25;
                break;
            default:
                lengthOfSentence = 0;
        }
        System.out.println("I sentence " + defendant + " to " + lengthOfSentence + " years in prison");
    }
}



public class Main {

    public static void main(String[] args) {
        CommonJudge firstJudge = new CommonJudge();
        firstJudge.myPower();
        firstJudge.judgement("Marcin", "murder");

        MilitaryJudge secondJudge = new MilitaryJudge();
        secondJudge.myPower();
        secondJudge.judgement("Szymon", "disobeying an order");

        MinistryOfHealth firstMinistry = new MinistryOfHealth();
        firstMinistry.manage();

        MinistryOfFinance secondMinistry = new MinistryOfFinance();
        secondMinistry.manage();

        Sejm lowerHouse = new Sejm();
        lowerHouse.vote(300);
        lowerHouse.vote(150);

        Senat upperHouse = new Senat();
        upperHouse.vote(80);
        upperHouse.vote(20);

        Senator marek = new Senator();
        marek.getAffiliation();
        marek.setAffiliation("p&s");
        marek.getAffiliation();


    }
}
