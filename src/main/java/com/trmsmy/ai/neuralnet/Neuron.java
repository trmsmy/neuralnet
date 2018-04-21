package com.trmsmy.ai.neuralnet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Neuron {

	private Neuron(Builder builder) {
		this.in = Arrays.asList(builder.ins);
		this.wt = Arrays.asList(builder.wts);
		this.bias = builder.bias;
	}

	List<Double> in;
	List<Double> wt;
	double bias;

	public int perceptron() {

		double sum = formula();

		int output = sum >= 0 ? 1 : 0;
		System.out.println(String.format("Perceptron: input(%s) wt(%s) bias(%s) = %s (%s) ", this.in, this.wt,
				this.bias, sum, output));

		return output;

	}

	public double sigmoid() {

		double sum = formula();

		double output = 1 / (1 + Math.exp(-sum));
		System.out.println(String.format("Sigmoid: input(%s) wt(%s) bias(%s) = %s (%s) ", this.in, this.wt, this.bias,
				sum, output));

		return output;

	}

	private double formula() {
		return IntStream.range(0, in.size()).mapToObj(i -> in.get(i) * wt.get(i))
				.collect(Collectors.summingDouble(Double::doubleValue)) + bias;
	}

	public static Builder _new(Double... Doubles) {
		Builder builder = new Builder();
		builder.ins = Doubles;
		return builder;
	}


	public static class Builder {
		Double[] ins;
		Double[] wts;
		Double bias;

		static Builder input(Double... ins) {
			Builder builder = new Builder();
			builder.ins = ins;
			return builder;
		}

		public Builder wts(Double... wts) {
			this.wts = wts;
			return this;
		}

		public Builder bias(Double bias) {
			this.bias = bias;
			return this;
		}

		public Neuron build() {
			return new Neuron(this);
		}

	}


}
