package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Boi;

public class App {

	private static Scanner ler = new Scanner(System.in);
	public static String nome;
	public static int idade;
	public static String nomeUltimaVacina;
	public static String dataUltimaVacina;
	public static float peso;
	private static int resposta;
	public static List<Boi> listaDeBois = new ArrayList<Boi>();

	public static void main(String[] args) throws InterruptedException, IOException {
		do {
			clearScreen();
			montaMenu();
			resposta = ler.nextInt();
			if (resposta == 1) {
				mostraBoi();
			}
			if (resposta == 2) {
				criaBoi();
			}
			if (resposta == 3) {
				editaBoi();
			}
			if (resposta == 4) {
				excluiBoi();
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

	private static void mostraBoi() {
		do {
			clearScreen();
			if (listaDeBois.size() > 0) {
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

	private static void criaBoi() {
		do {
			clearScreen();
			System.out.println("1 - Digite o nome do boi");
			System.out.print("Resposta: ");
			nome = ler.next();
			System.out.println("2 - digite a idade do boi");
			System.out.print("Resposta: ");
			idade = ler.nextInt();
			System.out.println("3 - Digite qual foi a última vacina que o boi tomou");
			System.out.print("Resposta: ");
			nomeUltimaVacina = ler.next();
			System.out.println("4 - Digite a data da última vacina que o boi tomou");
			System.out.print("Resposta: ");
			dataUltimaVacina = ler.next();
			System.out.println("5 - Digite o peso do boi");
			System.out.print("Resposta: ");
			peso = ler.nextFloat();
			Boi boi = new Boi(listaDeBois.size(), nome, idade, nomeUltimaVacina, dataUltimaVacina, peso);
			listaDeBois.add(boi);
			System.out.println("6 - Deseja cadastrar outro boi? (1 - SIM / 2 - NAO)");
			System.out.print("Resposta: ");
			resposta = ler.nextInt();
		} while (resposta != 2);
		resposta = 0;
	}

	private static void editaBoi() {
		do {
			clearScreen();
			if(listaDeBois.size() > 0) {
				criaTabela();
				System.out.println("Informe o ID do boi a ser alterado: ");
				resposta = ler.nextInt();
				alteraBoi(listaDeBois.get(resposta));
				resposta = 1;
			} else {
				mostraMensagemDeErro();
			}
		} while (resposta != 1);
		resposta = 0;
	}
	
	private static void alteraBoi(Boi boi) {
		clearScreen();
		if(listaDeBois.size() > 0) {
			System.out.println("1 - Digite o nome do boi");
			System.out.print("Resposta: ");
			nome = ler.next();
			boi.setNome(nome); 
			System.out.println("2 - Digite a idade do boi");
			System.out.print("Resposta: ");
			idade = ler.nextInt();
			boi.setIdade(idade); 
			System.out.println("3 - Digite qual foi a última vacina que o boi tomou");
			System.out.print("Resposta: ");
			nomeUltimaVacina = ler.next();
			boi.setNomeUltimaVacina(nomeUltimaVacina); 
			System.out.println("4 - Digite a data da última vacina que o boi tomou");
			System.out.print("Resposta: ");
			dataUltimaVacina = ler.next();
			boi.setDataUltimaVacina(dataUltimaVacina); 
			System.out.println("5 - Digite o peso do boi");
			System.out.print("Resposta: ");
			peso = ler.nextFloat();
			boi.setPeso(peso);
		}else {
			mostraMensagemDeErro();
		}
		resposta = 0;
	}

	private static void excluiBoi() {
		clearScreen();
		if (listaDeBois.size() > 0) {
			criaTabela();
			System.out.println("Informe o ID do boi a ser removido: ");
			resposta = ler.nextInt();
			listaDeBois.remove(resposta);
			for(int i = 0; i < listaDeBois.size(); i++) {
				listaDeBois.get(i).setId(i);
			}
		}else {
			mostraMensagemDeErro();
		}
		
		resposta = 0;
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}
	
	private static void criaTabela() {
		System.out.println(" __________________________________________________________________________________________");
		System.out.println("| " + String.format("%-4.4s", "ID") + "| "+ String.format("%-20.20s", "NOME") + "| " + String.format("%-7.7s", "IDADE") + "| " + String.format("%-20.20s", "ÚLT. VACINA") + "| " + String.format("%-20.20s", "DATA ÚLT. VACINA") + "| " + String.format("%-8.8s", "PESO") + "|");
		System.out.println("|------------------------------------------------------------------------------------------|");
		for (int i = 0; i < listaDeBois.size(); i++) {
			System.out.println("|" + String.format("%4.4s", listaDeBois.get(i).getId()) + " |" + String.format("%-20.20s", listaDeBois.get(i).getNome()) + " |" + String.format("%7.7s", listaDeBois.get(i).getIdade()) + " |" + String.format("%-20.20s", listaDeBois.get(i).getNomeUltimaVacina()) + " |" + String.format("%20.20s", listaDeBois.get(i).getDataUltimaVacina()) + " |" + String.format("%8.8s", listaDeBois.get(i).getPeso()) + " |");
		}
		System.out.println("|__________________________________________________________________________________________|");
		System.out.println("Quantidade de bois cadastrados: " + listaDeBois.size());
	}
	
	private static void mostraMensagemDeErro() {
		System.out.println("NENHUM BOI FOI CADASTRADO AINDA, RETORNE AO MENU E CADASTRE AO MENOS UM BOI!");
		System.out.println("Deseja retornar ao menu? (1 - SIM / 2 - NAO)");
		System.out.print("Resposta: ");
		resposta = ler.nextInt();
	}

}
