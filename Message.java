/*
Diese Klasse kapselt Informationen zu einer Nachricht.
Sie besitzt unveränderliche Objektvariablen zum Speichern
des Absenders (als String) und des Nachrichtentextes (als String).
*/

public class Message{

	//Fill in
	private String sender;
	private String text;	
	
	
	
/*Initialisiert dieses Message Objekt mit 
den übergebenen Parametern
@param sender der Name des Absenders
@param text der NAchrichtentext*/

public Message(String sender, String text){

	//Fill in
	this.sender = sender;
	this.text = text;
	
}

/*Liefert den Nachrichtentext zurück
@return den Nachrichtentext
*/

public String getText(){
	
	return text;
	//return null;

}

/*Liefert den Namen des Absenders zurück
@return den Namen des Absenders*/

public String getSender(){
	
	return sender;
	//return null;

}

/*Liefert eine lesbare Repräsentation
dieser Nachricht im folgenden Format:
<Absender>: <Text>*/

public String toString(){
	
	String nachricht = sender + ": " + text;
	return nachricht;
	//return null;

}


	
}
