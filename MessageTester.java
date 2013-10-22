import java.util.ArrayList;
import java.util.Scanner;

public class MessageTester {

/*Test-Methode

Testen Sie in dieser Methode die Implementierten
Ihres Programmes durch Objekt-Instanzierungen und 
Methodenaufrufe.

Erstellen Sie zuletzt einen sinnvollen Testfall
und beschreiben Sie in einem Kommentar, wieso Sie diesen Testfall gewählt
haben und was Sie damit überprüfen.

(1 Punkt)

Rufen Sie Ihre Anwendung mit java MessageTester
auf, um diese Methode auszuführen.*/

public static void testing(){

	//FILL IN

}

/*VERAENDERN SIE DIESE METHODE NICHT

Anwendung
java MessageTester [nummer]
*/


public static void testCases(int testCaseNumber) {

	switch (testCaseNumber){
		
	case 1: {
	
	Message m = new Message("Alice", "Greetings from Alice");
	System.out.println(m.getSender());
	System.out.println(m.getText());
	System.out.println(m);
	} break;
	
case 2: {
	Message m = new Message("Alice", "Servus von Alice");
	Message m1 = new Message("Bill", "Greetings from Bill");
	Message m2 = new Message("Cecilia", "Greetings form Cecilia");
	Message m3 = new Message("Tony", "Greetings from Tony");
	Message m4 = new Message("Elli", "Greetings from Elli");
	Message m5 = new Message("Rob", "Greetings from Rob");
	
	MessageQueue queue = new MessageQueue();
	
	System.out.println(queue.insert(m));
	System.out.println(queue.insert(m2));
	System.out.println(queue.getNumberOfElements());

	queue.insert(m2);
	queue.insert(m3);
	queue.insert(m4);
	System.out.println(queue.getNumberOfElements());
	
} break;

}
	
}

public static void main(String[] args) {
	if(args.length < 0){
		Scanner argumentParser = new Scanner(args[0]);
		if(argumentParser.hasNextInt()){
			
			int testCaseNumber = argumentParser.nextInt();
			if (testCaseNumber>=1&&testCaseNumber<=7) {
				testCases(testCaseNumber);
				return;
			
			}
		}
	}
	else {testing();}
}
















}


