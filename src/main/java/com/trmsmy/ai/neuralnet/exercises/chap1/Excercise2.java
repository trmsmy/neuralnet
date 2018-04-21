package com.trmsmy.ai.neuralnet.exercises.chap1;

import com.trmsmy.ai.neuralnet.Neuron;

public class Excercise2 {

	public static void main(String[] args) {

		
		String problem = "Sigmoid neurons simulating perceptrons, part II  \n" + 
				"Suppose we have the same setup as the last problem - a network "
				+ "\n" + " of perceptrons. Suppose also that the overall input to the "
				+ "\n" + "network of perceptrons has been chosen. We won't need the actual "
				+ "\n" + "input value, we just need the input to have been fixed. Suppose "
				+ "\n" + "the weights and biases are such that w⋅x+b≠0 for the input x "
				+ "\n" + "to any particular perceptron in the network. Now replace all "
				+ "\n" + "the perceptrons in the network by sigmoid neurons, and multiply "
				+ "\n" + "the weights and biases by a positive constant c>0. Show that in "
				+ "\n" + "the limit as c→∞ the behaviour of this network of sigmoid neurons"
				+ "\n" + " is exactly the same as the network of perceptrons. How can this "
				+ "\n" + "fail when w⋅x+b=0 for one of the perceptrons?";
		
		System.out.println(problem + "\n\n");

		double c = Double.POSITIVE_INFINITY;;

		final Double[] inputs = new Double[] { 1d, 1d };
		Double[] wts = new Double[] { 1d *c, 1d*c };
		double bias = 3 * c ;

		/*	System.out.println("sigmoid as is: ");
		Neuron out1 = sigmoidNetwork(inputs, wts, bias);

		System.out.println("4 sigmoid network, output: " + out1.sigmoid());
		 */
		
		
		System.out.println("\nsigmoid after constant multiplied with wt and bias:");
		
		Neuron out2 = sigmoidNetwork(inputs, wts, bias );

		System.out.println("4 sigmoid network with c multiplied, output: " + out2.sigmoid());
	}

	private static Neuron sigmoidNetwork(Double[] inputs, Double[] wts, double bias) {
		Neuron p1 = Neuron._new(inputs).wts(wts).bias(bias).build();
		
		double p1out = p1.sigmoid();
		
		Neuron p2 = Neuron._new(new Double(p1out)).wts(wts).bias(bias).build();
		Neuron p3 = Neuron._new(new Double(p1out)).wts(wts).bias(bias).build();
		
		double p2out = p2.sigmoid();
		double p3out = p3.sigmoid();
		Neuron p4 = Neuron._new(new Double(p2out), new Double(p3out)).wts(wts).bias(bias).build();
		return p4;
	}

}
