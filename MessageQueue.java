/*Diese Klasse stellt die Funktionalität einer Queue bereit.
Diese Queue dient zur Verwanltung von Messages.
Eine Queue arbeitet nach dem First-In-First-Out Prinzip, d.h.
es wird immer die älteste Message als erstes ausgelesen.
Die Queue soll mit Hilfe eines eindimensionalen Arrays 
realisiert werden.*/

import java.util.ArrayList;

public class MessageQueue{

//FILL IN
	private Message[] queue;
	public int counter = 0;

/*Initialisiert dieses MessageQueue Objekt
mit einer Queue der Größe 5. Verwenden Sie zur
Implementierung einen existierenden Konstruktor*/

public MessageQueue(){

	//FILL IN
	MessageQueue queue = new MessageQueue(5);
	
	
	
}

/*Initialisiert dieses MessageQueue Objekt der
spezifizierten Größe.
@param size die Größe der Queue*/

public MessageQueue(int size) {

	//FILL IN
	this.queue = new Message[size];

}

/*Initialisiert dieses MessageQueue Objekt,
als unabhängige Kopie der übergebenen
MessageQueue.
@param q die MessageQueue von der kopiert werden soll*/

public MessageQueue(MessageQueue q){

	//FILL IN
	this.queue = new Message[q.getQueue().length];
	for(int i=0; i<q.getCounter();i++){
		int j=0;
		this.queue[i]= new Message(q.getQueue()[j].getSender(),
			q.getQueue()[j].getText());
		this.counter=this.counter+1;
		}
	
	
}

public int getCounter(){

	//return -1; //löschen
	return this.counter;
}

/*Fügt ein neues Element (darf auch <code>null</code> sein)
in die Queue ein.
Ein neues Element wird an die erste leere Position
eingefügt. Sind keine freien Plätze mehr verfügbar,
wird das Element nicht eingefügt und false retourniert.

@param m das einzufügende Element (<code>null</code> ist zulässig)
@return true, wenn das Einfügen erfolgreich war, sonst false.*/

public boolean insert(Message m){

	//return false; //löschen
	if(counter+1<=queue.length){
		queue[counter] = m;
		counter++;
		return true;
	} else {
		return false;
	}

}

public Message[] getQueue(){
	//return null;
	return this.queue;
}

/*Liefert das älteste Element der Queue
(also das Element an Position 0)
Das Element soll dabei NICHT gelöscht werden. 
Wenn sich keine Elemente in der Queue befinden, 
soll null zurückgegeben werden.

@return das älteste (erste) Element der Queue*/

public Message peek(){

	return queue[0];
}

/*Liefert das älteste Element der Queue und entfernt es*/

public Message poll(){

	//FILL IN
	Message w = queue[0];
	for(int i=0; i<queue.length-1;i++){
		queue[i]= queue[i+1];	
	}
	this.counter--;
	return w;
	//return null;
	

}

/*Liefert eine Liste der ältesten Elemente der Queue. <code> count </code> gibt
die Anzahl der zu liefernden Elemente an.
Diese Elemente sollen zudem aus der Queue entfernt werden.

@param count die Anzahl an Elementen, die geliefert werden sollen
@return eine Liste, die die count ältesten Elemente der Queue enthält.*/

public ArrayList<Message> poll(int count){
	
	//FILL IN
	ArrayList<Message> liste = new ArrayList<Message>();
	
	for(int i=0; i<count||count>queue.length; i++){
		liste.add(this.queue[i]);
	}
	for(int i=0; i<this.queue.length-count;i++){
		this.queue[i]=this.queue[i+count];
	}
	this.counter=counter-count;
	
	return liste;
}

/*Liefert alle Elemente der Queue und entfernt diese aus der Queue.
Nach Aufruf dieser Methode ist die Queue leer und 
alle Elemente, die zuvor in der Queue gestanden
sind, werden in einer ArrayList zurückgeliefert.

@return eine Liste, die alle Elemente der Queue enthält.*/

public ArrayList<Message> pollAll(){

	//FILL IN
	ArrayList<Message> alleElemente = new ArrayList<Message>();
	
	for(int i=0; i<this.counter; i++){
		alleElemente.add(this.queue[i]);
	}
	int size = this.queue.length;
	this.queue = new Message[size];
	this.counter=0;
	return alleElemente;
	
	//return null;
}

/*Liefert die Anzahl an Elementen (ungleich null)
der Queue zurück
@return die Anzahl an Elementen als int*/

public int getNumberOfElements(){

	return counter;
	//return -1; //löschen
}






}


