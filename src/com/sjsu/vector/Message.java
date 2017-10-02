package com.sjsu.vector;

public class Message {

	MessageType messageType;
	VectorClock vc;
	
	
	public Message(MessageType mt, VectorClock vc) {
		this.messageType=mt;
		this.vc = vc;
	}

	public VectorClock getVc() {
		return vc;
	}

	public void setVc(VectorClock vc) {
		this.vc = vc;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
}
