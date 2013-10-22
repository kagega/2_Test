import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*Diese Klasse repräsentiert einen Nachrichtenserver, auf dem Nachrichten
für Benutzer hinterlegt und zu einem späteren Zeitpunkt ausgelesen
werden können. Die Hinterlegung der Nachrichten ist über eine 
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
indem es eine unabhängige Kopie des übergebenen MessageServers
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

/*Hinterlegt eine neue Nachricht für den spezifizierten Benutzer.
Die Nachricht soll dabei in die MessageQueue des Empfängers (receiver)
gelegt werden. Gibt es für diesen Empfänger noch keine MessageQueue,
so soll für diesen Empfänger eine neue MessageQueue der Größe 3 angelegt 
und der HashMap hinzugefügt werden.

Ist die MessageQueue des Empfängers bereits voll, 
soll die Nachricht einfach verworfen werden.

Erhöhen Sie bei Bedarf den Wert, der die Anzahl an gespeicherten
Nachrichten repräsentiert.

@param receiver der Empfänger, dem die Nachricht zugestellt werden soll
@param m die Nachricht, die zugestellt werden soll
@return true, wenn in der MessageQueue des Empfängers noch genügend Platz war
und die Nachricht hinzugefügt werden konnte, sonst false.
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
	
	return false; //löschen
	
}

/*Liefert die älteste Nachricht, die für den spezifizierten 
Empfänger verfügbar ist. Die Nachricht soll dabei NICHT vom 
Server entfernt werden.

Wenn für diesen Empfänger noch keine MessageQueue existiert, soll
stattdessen null zurückgeliefert werden.

@param receiver der Emfpänger, für den die älteste Nachricht ausgelesen werden
soll
@return die älteste Nachricht*/

public Message receiveOldest(String receiver){

	//FILL IN
	if(messages.containsKey(receiver)){
		return messages.get(receiver).peek();
	}
	
	return null;
}

/*Liefert die älteste Nachricht, die für den spezifizierten 
Empfänger verfügbar ist, und entfernt diese von der MessageQueue.
Wenn für diesen Empfänger noch keine MessageQueue existiert, 
soll stattdessen null zurückgeliefert werden.

Achten Sie hierbei darauf, auch den Wert für die Anzahl an 
gespeicherten Nachrichten entsprechend anzupassen.

@param receiver der Empfänger, für den die älteste Nachricht ausgelesen werden soll.
@return die älteste Nachricht*/

public Message downloadOldest(String receiver){

	//FILL IN
	return null;

}

/*Liefert alle Nachrichten, die für den spezifizierten Empfänger 
verfügbar sind und entfernt diese von der MessageQueue.
Weiters osll anschließend der Eintrag für den spezifizierten
Empfänger aus der HashMap entfernt werden.

Wenn für diesen Empfänger noch keine MessageQueue existiert,
soll stattdessen null zurückgeliefert werden.

Achten Sie hierbei darauf, auch den Wert für die Anzahl an
gespeicherten Nachrichten entsprechend anzupassen.

@param receiver der Empfänger, für den die Nachrichten ausgelesen werden sollen
@return eine Liste, die alle Nachrichten des Emfpängers enthält.
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

/*Liefert die GEsamtanzahl an NAchrichten, die dieser Server speichert, zurück.
@return die Anzahl an NAchrichten als int*/


public int amount(){
	//FILL IN
	return messages.size();
	//return -1;
}

/*Liefert eine Übersicht über die gespeicherten Nachrichten
(gesamt und pro Benutzer).
Der zurückgelieferte String soll folgendermaßen aussehen:
GEsamt: <Anzahl> Nachrichten
Alice: <Anzahl> Nachrichten
Mark: <Anzahl> Nachrichten
...

@return einen String, der die gefragten Daten enthält
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

