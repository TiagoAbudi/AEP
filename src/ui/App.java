package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Animal;

public class App {

	private static Scanner ler = new Scanner(System.in);
	public static String nome;
	public static int idade;
	public static String nomeUltimaVacina;
	public static String dataUltimaVacina;
	public static float peso;
	private static int resposta;
	public static List<Animal> listaDeAnimais = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException, IOException {
		do {
			clearScreen();
			montaMenu();
			resposta = ler.nextInt();
			if (resposta == 1) {
				mostraAnimal();
			}
			if (resposta == 2) {
				criaAnimal();
			}
			if (resposta == 3) {
				editaAnimal();
			}
			if (resposta == 4) {
				excluiAnimal();
			}
		} while (resposta != 5);

	}

	private static void montaMenu() {
		System.out.println(" __________________________________ ");
		System.out.println("| 1 - Animais cadastrados          |");
		System.out.println("| 2 - Cadastrar um novo animal     |");
		System.out.println("| 3 - Editar um animal cadastrado  |");
		System.out.println("| 4 - Excluir um animal cadastrado |");
		System.out.println("| 5 - Sair                         |");
		System.out.println("|__________________________________|");
		System.out.print("Resposta: ");
		resposta = 0;
	}

	private static void mostraAnimal() {
		do {
			clearScreen();
			if (listaDeAnimais.size() > 0) {
				criaTabela();
				System.out.println("Deseja retornar ao menu? (1 - SIM / 2 - NAO)");
				System.out.print("Resposta: ");
				resposta = ler.nextInt();
			} else {
				mostraMensagemDeErro();
			}
		} while (resposta != 1);
		resposta = 0;
	}

	private static void criaAnimal() {
		do {
			clearScreen();
			System.out.println("1 - Digite o nome do animal");
			System.out.print("Resposta: ");
			nome = ler.next();
			System.out.println("2 - digite a idade do animal");
			System.out.print("Resposta: ");
			idade = ler.nextInt();
			System.out.println("3 - Digite qual foi a �ltima vacina que o animal tomou");
			System.out.print("Resposta: ");
			nomeUltimaVacina = ler.next();
			System.out.println("4 - Digite a data da �ltima vacina que o animal tomou");
			System.out.print("Resposta: ");
			dataUltimaVacina = ler.next();
			System.out.println("5 - Digite o peso do animal");
			System.out.print("Resposta: ");
			peso = ler.nextFloat();
			Animal boi = new Animal(listaDeAnimais.size(), nome, idade, nomeUltimaVacina, dataUltimaVacina, peso);
			listaDeAnimais.add(boi);
			System.out.println("6 - Deseja cadastrar outro animal? (1 - SIM / 2 - NAO)");
			System.out.print("Resposta: ");
			resposta = ler.nextInt();
		} while (resposta != 2);
		resposta = 0;
	}

	private static void editaAnimal() {
		do {
			clearScreen();
			if (listaDeAnimais.size() > 0) {
				criaTabela();
				System.out.println("Informe o ID do animal a ser alterado: ");
				resposta = ler.nextInt();
				alteraAnimal(listaDeAnimais.get(resposta));
				resposta = 1;
			} else {
				mostraMensagemDeErro();
			}
		} while (resposta != 1);
		resposta = 0;
	}

	private static void alteraAnimal(Animal animal) {
		clearScreen();
		if (listaDeAnimais.size() > 0) {
			System.out.println("1 - Digite o nome do animal");
			System.out.print("Resposta: ");
			nome = ler.next();
			animal.setNome(nome);
			System.out.println("2 - Digite a idade do animal");
			System.out.print("Resposta: ");
			idade = ler.nextInt();
			animal.setIdade(idade);
			System.out.println("3 - Digite qual foi a �ltima vacina que o animal tomou");
			System.out.print("Resposta: ");
			nomeUltimaVacina = ler.next();
			animal.setNomeUltimaVacina(nomeUltimaVacina);
			System.out.println("4 - Digite a data da �ltima vacina que o animal tomou");
			System.out.print("Resposta: ");
			dataUltimaVacina = ler.next();
			animal.setDataUltimaVacina(dataUltimaVacina);
			System.out.println("5 - Digite o peso do animal");
			System.out.print("Resposta: ");
			peso = ler.nextFloat();
			animal.setPeso(peso);
		} else {
			mostraMensagemDeErro();
		}
		resposta = 0;
	}

	private static void excluiAnimal() {
		clearScreen();
		if (listaDeAnimais.size() > 0) {
			criaTabela();
			System.out.println("Informe o ID do animal a ser removido: ");
			resposta = ler.nextInt();
			listaDeAnimais.remove(resposta);
			for (int i = 0; i < listaDeAnimais.size(); i++) {
				listaDeAnimais.get(i).setId(i);
			}
		} else {
			mostraMensagemDeErro();
		}

		resposta = 0;
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

	private static void criaTabela() {
		System.out
				.println(" __________________________________________________________________________________________");
		System.out.println("| " + String.format("%-4.4s", "ID") + "| " + String.format("%-20.20s", "NOME") + "| "
				+ String.format("%-7.7s", "IDADE") + "| " + String.format("%-20.20s", "�LT. VACINA") + "| "
				+ String.format("%-20.20s", "DATA �LT. VACINA") + "| " + String.format("%-8.8s", "PESO") + "|");
		System.out.println(
				"|------------------------------------------------------------------------------------------|");
		for (Animal element : listaDeAnimais) {
			System.out.println("|" + String.format("%4.4s", element.getId()) + " |"
					+ String.format("%-20.20s", element.getNome()) + " |"
					+ String.format("%7.7s", element.getIdade()) + " |"
					+ String.format("%-20.20s", element.getNomeUltimaVacina()) + " |"
					+ String.format("%20.20s", element.getDataUltimaVacina()) + " |"
					+ String.format("%8.8s", element.getPeso()) + " |");
		}
		System.out.println(
				"|__________________________________________________________________________________________|");
		System.out.println("Quantidade de animais cadastrados: " + listaDeAnimais.size());
	}

	private static void mostraMensagemDeErro() {
		System.out.println("NENHUM ANIMAL FOI CADASTRADO AINDA, RETORNE AO MENU E CADASTRE AO MENOS UM ANIMAL!");
		System.out.println("Deseja retornar ao menu? (1 - SIM / 2 - NAO)");
		System.out.print("Resposta: ");
		resposta = ler.nextInt();
	}

}
