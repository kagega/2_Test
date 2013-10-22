import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*Diese Klasse repr�sentiert einen Nachrichtenserver, auf dem Nachrichten
f�r Benutzer hinterlegt und zu einem sp�teren Zeitpunkt ausgelesen
werden k�nnen. Die Hinterlegung der Nachrichten ist �ber eine 
HashMap realisiert.*/

public class MessageServer{

	//FILL IN
	
	private HashMap<String, MessageQueue> messages;
	private int numberOfMessages = 0;
	
/*Initialisiert ein neues leeres MessageServer Objekt*/

public MessageServer(){

	//FILL IN
	messages = new HashMap<String, MessageQueue>();


}

/*Initialisiert ein neues MessageServer Objekt,
indem es eine unabh�ngige Kopie des �bergebenen MessageServers
erstellt.
@param ms das Objekt von dem kopiert werden soll*/

public MessageServer(MessageServer ms){

	//FILL IN
	messages = new HashMap<String, MessageQueue>();
        
        Iterator<Entry<String,MessageQueue>> iter = ms.messages.entrySet().iterator();
        while (iter.hasNext()){
messages.put(iter.next().getKey(), new MessageQueue(iter.next().getValue()));
        }
        

}

/*Hinterlegt eine neue Nachricht f�r den spezifizierten Benutzer.
Die Nachricht soll dabei in die MessageQueue des Empf�ngers (receiver)
gelegt werden. Gibt es f�r diesen Empf�nger noch keine MessageQueue,
so soll f�r diesen Empf�nger eine neue MessageQueue der Gr��e 3 angelegt 
und der HashMap hinzugef�gt werden.

Ist die MessageQueue des Empf�ngers bereits voll, 
soll die Nachricht einfach verworfen werden.

Erh�hen Sie bei Bedarf den Wert, der die Anzahl an gespeicherten
Nachrichten repr�sentiert.

@param receiver der Empf�nger, dem die Nachricht zugestellt werden soll
@param m die Nachricht, die zugestellt werden soll
@return true, wenn in der MessageQueue des Empf�ngers noch gen�gend Platz war
und die Nachricht hinzugef�gt werden konnte, sonst false.
*/

public boolean send(String receiver, Message m){
	
	MessageQueue mq = null;
	if(!messages.containsKey(receiver)) {
		mq = new MessageQueue(3);
		messages.put(receiver, mq);
	}
	mq = messages.get(receiver);
	numberOfMessages = mq.getNumberOfElements();
	if(mq.getNumberOfElements() < mq.getQueue().length) {
		mq.insert(m);
		numberOfMessages=numberOfMessages+1;
		return true;
	}
	
	return false; //l�schen
	
}

/*Liefert die �lteste Nachricht, die f�r den spezifizierten 
Empf�nger verf�gbar ist. Die Nachricht soll dabei NICHT vom 
Server entfernt werden.

Wenn f�r diesen Empf�nger noch keine MessageQueue existiert, soll
stattdessen null zur�ckgeliefert werden.

@param receiver der Emfp�nger, f�r den die �lteste Nachricht ausgelesen werden
soll
@return die �lteste Nachricht*/

public Message receiveOldest(String receiver){

	//FILL IN
	if(messages.containsKey(receiver)){
		return messages.get(receiver).peek();
	}
	
	return null;
}

/*Liefert die �lteste Nachricht, die f�r den spezifizierten 
Empf�nger verf�gbar ist, und entfernt diese von der MessageQueue.
Wenn f�r diesen Empf�nger noch keine MessageQueue existiert, 
soll stattdessen null zur�ckgeliefert werden.

Achten Sie hierbei darauf, auch den Wert f�r die Anzahl an 
gespeicherten Nachrichten entsprechend anzupassen.

@param receiver der Empf�nger, f�r den die �lteste Nachricht ausgelesen werden soll.
@return die �lteste Nachricht*/

public Message downloadOldest(String receiver){

	//FILL IN
	return null;

}

/*Liefert alle Nachrichten, die f�r den spezifizierten Empf�nger 
verf�gbar sind und entfernt diese von der MessageQueue.
Weiters osll anschlie�end der Eintrag f�r den spezifizierten
Empf�nger aus der HashMap entfernt werden.

Wenn f�r diesen Empf�nger noch keine MessageQueue existiert,
soll stattdessen null zur�ckgeliefert werden.

Achten Sie hierbei darauf, auch den Wert f�r die Anzahl an
gespeicherten Nachrichten entsprechend anzupassen.

@param receiver der Empf�nger, f�r den die Nachrichten ausgelesen werden sollen
@return eine Liste, die alle Nachrichten des Emfp�ngers enth�lt.
*/

public ArrayList<Message> downloadAll(String receiver){

	//FILL IN
	ArrayList<Message> all = new ArrayList<Message>();
		if(messages.containsKey(receiver)){
			all.addAll(messages.get(receiver).pollAll());
			numberOfMessages = numberOfMessages-all.size();
			return all;
		}
	
	
	return null;
}

/*Liefert die GEsamtanzahl an NAchrichten, die dieser Server speichert, zur�ck.
@return die Anzahl an NAchrichten als int*/


public int amount(){
	//FILL IN
	return messages.size();
	//return -1;
}

/*Liefert eine �bersicht �ber die gespeicherten Nachrichten
(gesamt und pro Benutzer).
Der zur�ckgelieferte String soll folgenderma�en aussehen:
GEsamt: <Anzahl> Nachrichten
Alice: <Anzahl> Nachrichten
Mark: <Anzahl> Nachrichten
...

@return einen String, der die gefragten Daten enth�lt
*/

public String allocation(){

	//FILL IN
	String ausgabe = "Gesamt: " + messages.size() + " Nachrichten" + "\n";
	for(String key : messages.keySet()){
		ausgabe += key + ": " + messages.get(key) + " Nachrichten" + "\n";
	}
	return ausgabe;

}

}

