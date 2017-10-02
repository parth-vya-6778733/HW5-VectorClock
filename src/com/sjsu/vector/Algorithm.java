package com.sjsu.vector;

import java.util.List;

public class Algorithm {
	int noOfProcessors;
	Processor p0, p1, p2; // Assume there are three processors.

	public Algorithm() {
		super();
		this.noOfProcessors = 3;
		// TODO : initialize all the processors
		p0 = new Processor(0, 3);
		p1 = new Processor(1, 3);
		p2 = new Processor(2, 3);
	}

	// Write hard coded execution plan for processors
	public void executionPlanForP0() throws RuntimeException {
		// TODO: call events on P0 for compute.
		// Call send events to send message
		// Call receive messages
		try {
			// φ1→φ6
			compute(p0, new Message(MessageType.COMPUTATION, p0.getVc()));
			send(p0, p1, new Message(MessageType.SEND, p0.getVc()));
			Thread.sleep(4000);
			//φ2→φ13
			compute(p0, new Message(MessageType.COMPUTATION, p0.getVc()));
			send(p0, p2, new Message(MessageType.SEND, p0.getVc()));
			Thread.sleep(1000);
			//φ3
			compute(p0, new Message(MessageType.COMPUTATION, p0.getVc()));
			Thread.sleep(1000);
			//φ9→φ4
			compute(p0, new Message(MessageType.COMPUTATION, p0.getVc()));
			receive(p1, p0, new Message(MessageType.RECEIVE, p0.getVc()));
			//φ5
			compute(p0, new Message(MessageType.COMPUTATION, p0.getVc()));
			System.out.println("---Processor 0--- ");
			System.out.println(p0.toString());
		}catch(Exception e)
		{
			System.out.println("Error" + e);
		}


	}

	// Write hard coded execution plan for processors
	public void executionPlanForP1() throws RuntimeException{
		// TODO: call events on P0 for compute.
		// Call send events to send message
		// Call receive messages

		try {
			//φ1→φ6
			compute(p1, new Message(MessageType.COMPUTATION, p1.getVc()));
			receive(p0, p1, new Message(MessageType.RECEIVE, p1.getVc()));
			//φ12→φ7
			Thread.sleep(3000);
			compute(p1, new Message(MessageType.COMPUTATION, p1.getVc()));
			receive(p0, p1, new Message(MessageType.RECEIVE, p0.getVc()));
			//φ8→φ15
			compute(p1, new Message(MessageType.COMPUTATION, p1.getVc()));
			send(p1, p2, new Message(MessageType.SEND, p1.getVc()));
			Thread.sleep(1000);
			//φ14→φ9
			compute(p1, new Message(MessageType.COMPUTATION, p1.getVc()));
			receive(p2, p1, new Message(MessageType.RECEIVE, p2.getVc()));
			Thread.sleep(1000);
			System.out.println("---Processor 1--- ");
			System.out.println(p1.toString());
		}catch (Exception e)
		{
			System.out.println("Error" + e);
		}


	}

	// Write hard coded execution plan for processors
	public void executionPlanForP2() throws RuntimeException {
		// TODO: call events on P0 for compute.
		// Call send events to send message
		// Call receive messages

		try {
			//φ10
			compute(p2, new Message(MessageType.COMPUTATION, p2.getVc()));
			//φ11
			compute(p2, new Message(MessageType.COMPUTATION, p2.getVc()));
			//φ12→φ7
			compute(p2, new Message(MessageType.COMPUTATION, p2.getVc()));
			send(p2, p1, new Message(MessageType.SEND, p2.getVc()));
			//φ2→φ13
			Thread.sleep(5000);
			compute(p2, new Message(MessageType.COMPUTATION, p2.getVc()));
			receive(p1, p2, new Message(MessageType.RECEIVE, p1.getVc()));
			//φ14→φ9
			compute(p2, new Message(MessageType.COMPUTATION, p2.getVc()));
			send(p2, p1, new Message(MessageType.SEND, p2.getVc()));
			Thread.sleep(1000);
			//φ8→φ15
			compute(p2, new Message(MessageType.COMPUTATION, p2.getVc()));
			receive(p1, p2, new Message(MessageType.RECEIVE, p1.getVc()));
			//φ16
			compute(p2, new Message(MessageType.COMPUTATION, p2.getVc()));
			System.out.println("---Processor 2--- ");
			System.out.println(p2.toString());
		}catch (Exception e)
		{
			System.out.println("Error" + e);
		}



	}
	/**
	 * 
	 * @param p
	 * @param computeMessage
	 */
	public void compute(Processor p, Message computeMessage) {
		// TODO: implement. What will be the value of vector clock passed to
		// this message?
		p.sendMessgeToMyBuffer(computeMessage);
	}

	public void send(Processor from, Processor to, Message m) {
		// TODO: implement. What will be the value of vector clock passed to
		// this message?

		//from.sendMessgeToMyBuffer(m);
		to.sendMessgeToMyBuffer(m, from);

	}

	public void receive(Processor from, Processor to, Message m) {
		// TODO: implement. What will be the value of vector clock passed to
		// this message?

		//from.sendMessgeToMyBuffer(m);
		to.sendMessgeToMyBuffer(m, from);

	}

}

class Executor1 implements Runnable
{
	Algorithm a;

	public Executor1(Algorithm a)
	{
		this.a = a;
	}

	@Override
	public void run() {
		this.a.executionPlanForP0();
	}
}

class Executor2 implements Runnable
{
	Algorithm a;

	public Executor2(Algorithm a)
	{
		this.a = a;
	}

	@Override
	public void run() {
		this.a.executionPlanForP1();
	}
}

class Executor3 implements Runnable
{
	Algorithm a;

	public Executor3(Algorithm a)
	{
		this.a = a;
	}

	@Override
	public void run() {
		this.a.executionPlanForP2();
	}
}