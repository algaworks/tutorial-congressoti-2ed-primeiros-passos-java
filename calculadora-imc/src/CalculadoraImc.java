
public class CalculadoraImc {

	public static void main(String[] args) {
		System.out.println("Calculadora IMC");

		// Cálculo do IMC é: imc = peso / altura * altura
		float peso = Float.valueOf(args[0]);
		float altura = Float.valueOf(args[1]);

		float imc = peso / (altura * altura);
		System.out.println("Peso: " + peso);
		System.out.println("Altura: " + altura);
		System.out.printf("Seu IMC é: %.2f\n", imc);
	}
	
}
