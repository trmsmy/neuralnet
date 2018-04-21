package com.trmsmy.ai.neuralnet;

public class NeuronRunner {
	public static void main(String[] args) {
		
		
		//Perceptron 
		Neuron._new(1d, 1d).wts(-2d, -2d).bias(3d).build().perceptron();
		
		Neuron._new(0d, 0d).wts(-2d, -2d).bias(3d).build().perceptron(); 
		
		//sigmoid 
		Neuron._new(1d, 1d).wts(-2d, -2d).bias(3d).build().sigmoid();
		Neuron._new(0d, 0d).wts(-2d, -2d).bias(3d).build().sigmoid(); 
		
		
		//sigmoid step function 
		System.out.println("\nSigmoid step function \n");
		Neuron._new(-100000000d, -100000000d).wts(2d, 2d).bias(3d).build().sigmoid();
		Neuron._new(0d, 0d).wts(2d, 2d).bias(3d).build().sigmoid();
		Neuron._new(1000000d, 1000000d).wts(2d, 2d).bias(3d).build().sigmoid();
		
		
	}
}