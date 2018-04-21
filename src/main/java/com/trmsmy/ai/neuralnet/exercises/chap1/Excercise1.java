package com.trmsmy.ai.neuralnet.exercises.chap1;

import com.trmsmy.ai.neuralnet.Neuron;

public class Excercise1 {

	public static void main(String[] args) {

		String problem = "Sigmoid neurons simulating perceptrons, part I  \n"
				+ "Suppose we take all the weights and biases in a network of"
				+ " perceptrons, and multiply them by a positive constant, c>0. "
				+ "Show that the behaviour of the network doesn't change.";

		System.out.println(problem + "\n\n");

		System.out.println("Perceptron as is: ");

		final Double[] inputs = new Double[] { 1d, 1d };
		Double[] wts = new Double[] { 1d, 1d };
		double bias = 3;

		Neuron out1 = perceptronNetwork(inputs, wts, bias);

		System.out.println("4 Perceptrons network, output: " + out1.perceptron());

		
		
		System.out.println("\nPerceptron after constant multiplied with wt and bias:");
		double c = 10d;
		wts = new Double[] { 1d *c, 1d*c };
		bias = 3 * c ;
		Neuron out2 = perceptronNetwork(inputs, wts, bias );

		System.out.println("4 Perceptrons network with c multiplied, output: " + out2.perceptron());
	}

	private static Neuron perceptronNetwork(Double[] inputs, Double[] wts, double bias) {
		Neuron p1 = Neuron._new(inputs).wts(wts).bias(bias).build();
		
		int p1out = p1.perceptron();
		
		Neuron p2 = Neuron._new(new Double(p1out)).wts(wts).bias(bias).build();
		Neuron p3 = Neuron._new(new Double(p1out)).wts(wts).bias(bias).build();
		
		int p2out = p2.perceptron();
		int p3out = p3.perceptron();
		Neuron p4 = Neuron._new(new Double(p2out), new Double(p3out)).wts(wts).bias(bias).build();
		return p4;
	}

}
