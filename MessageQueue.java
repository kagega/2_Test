/*Diese Klasse stellt die Funktionalit�t einer Queue bereit.
Diese Queue dient zur Verwanltung von Messages.
Eine Queue arbeitet nach dem First-In-First-Out Prinzip, d.h.
es wird immer die �lteste Message als erstes ausgelesen.
Die Queue soll mit Hilfe eines eindimensionalen Arrays 
realisiert werden.*/

import java.util.ArrayList;

public class MessageQueue{

//FILL IN
	private Message[] queue;
	public int counter = 0;

/*Initialisiert dieses MessageQueue Objekt
mit einer Queue der Gr��e 5. Verwenden Sie zur
Implementierung einen existierenden Konstruktor*/

public MessageQueue(){

	//FILL IN
	MessageQueue queue = new MessageQueue(5);
	
	
	
}

/*Initialisiert dieses MessageQueue Objekt der
spezifizierten Gr��e.
@param size die Gr��e der Queue*/

public MessageQueue(int size) {

	//FILL IN
	this.queue = new Message[size];

}

/*Initialisiert dieses MessageQueue Objekt,
als unabh�ngige Kopie der �bergebenen
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

	//return -1; //l�schen
	return this.counter;
}

/*F�gt ein neues Element (darf auch <code>null</code> sein)
in die Queue ein.
Ein neues Element wird an die erste leere Position
eingef�gt. Sind keine freien Pl�tze mehr verf�gbar,
wird das Element nicht eingef�gt und false retourniert.

@param m das einzuf�gende Element (<code>null</code> ist zul�ssig)
@return true, wenn das Einf�gen erfolgreich war, sonst false.*/

public boolean insert(Message m){

	//return false; //l�schen
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

/*Liefert das �lteste Element der Queue
(also das Element an Position 0)
Das Element soll dabei NICHT gel�scht werden. 
Wenn sich keine Elemente in der Queue befinden, 
soll null zur�ckgegeben werden.

@return das �lteste (erste) Element der Queue*/

public Message peek(){

	return queue[0];
}

/*Liefert das �lteste Element der Queue und entfernt es*/

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

/*Liefert eine Liste der �ltesten Elemente der Queue. <code> count </code> gibt
die Anzahl der zu liefernden Elemente an.
Diese Elemente sollen zudem aus der Queue entfernt werden.

@param count die Anzahl an Elementen, die geliefert werden sollen
@return eine Liste, die die count �ltesten Elemente der Queue enth�lt.*/

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
sind, werden in einer ArrayList zur�ckgeliefert.

@return eine Liste, die alle Elemente der Queue enth�lt.*/

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
der Queue zur�ck
@return die Anzahl an Elementen als int*/

public int getNumberOfElements(){

	return counter;
	//return -1; //l�schen
}






}


