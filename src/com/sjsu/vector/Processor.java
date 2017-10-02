package com.sjsu.vector;

import java.util.Observable;
import java.util.Observer;

/**
 * Performs all the processor related tasks
 * @author Sample
 * @version 1.0
 *
 */
public class Processor implements Observer {
	//TODo : add appropriate visibility indicators to each member variable
    Buffer messageBuffer ;
    Integer id ;

    //TODO: Think through when would you need a list of vector clocks
    VectorClock vc ; //This is the current vector clock
    Processor from;
    
    /**
     * Initializes the processor with id, children and unexplored lists. Adds himself in the observers list.
     * @param id of the processor
     */
    public Processor(int id, int totalProcesors) {
        messageBuffer = new Buffer();
        this.id = id; 
        messageBuffer.addObserver(this);
        this.vc = new VectorClock(totalProcesors);
    }

    public VectorClock getVc() {
        return vc;
    }

    public void setVc(VectorClock vc) {
        this.vc = vc;
    }
    
    /**
     * Overloaded method, called with single argument
     * This method will add a message to this processors buffer.
     * Other processors will invoke this method to send a message to this Processor
     * @param message Message to be sent
     */
    public void sendMessgeToMyBuffer(Message message){
    	//TODO: implement

        this.messageBuffer.setMessage(message);
    }

    public void sendMessgeToMyBuffer(Message message, Processor from){
        //TODO: implement
        this.from = from;
        this.messageBuffer.setMessage(message);
    }

    /**
     * Gets called when a node receives a message in it buffer
     * Processes the message received in the buffer
     */
    public void update(Observable observable, Object arg) {
    	calculateVectorClocks(observable, arg);
    }

    //TODO: Discuss does this method need to return a vector clock? or is void enough.
    public void calculateVectorClocks(Observable observable, Object arg) {
    	//TODO: Implement the logic to check based on the current vector clocks and the vector clock
    	//Hint: Get vector clocks for this processor and message from this processors buffer
    	//invoke methods of VectorClock
        Message tmpMessage = this.messageBuffer.getMessage();

        switch(tmpMessage.getMessageType()){
            case COMPUTATION:
            {
                this.vc.vc[id]++;
                break;
            }
            case SEND:
            {
                if(this.vc.compareTo(from.vc) > 0)
                {
                    for(int i = 0; i < this.vc.vc.length; i++) {
                        if(i != id) {
                            this.vc.vc[i] = from.vc.vc[i];
                        }
                    }
                }
                break;
            }
            case RECEIVE:
            {
                if(this.vc.compareTo(from.vc) > 0)
                {
                    for(int i = 0; i < this.vc.vc.length; i++) {
                        if(i != id) {
                            this.vc.vc[i] = from.vc.vc[i];
                        }
                    }
                }

                break;
            }

        }
    	
    }

    @Override
    public String toString() {
        String finalVC = "";
        for (int p=0; p < vc.vc.length; p++)
        {
            finalVC = finalVC + "p"+p+": " + vc.vc[p] + "\n";
        }
        return finalVC;
    }
}
