import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }

    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas ++;
            } else {
                System.err.println("Contato realizado com sucesso");
            }

        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("Conseguimos contato com "+ candidato + " na " + tentativasRealizadas + " tentativa");
        } else {
            System.out.println("Não conseguimos contato com " + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if(salarioBase > salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados ++;
            } else if(salarioBase+200 > salarioPretendido && salarioBase+1 < salarioPretendido) {
                System.out.println("Ligar para o candidato com contra proposta");
            } else if (salarioPretendido > salarioBase+200){
                System.out.println("Aguardar outros candidatos");
            }
            System.out.println(candidatosSelecionados);
            candidatosAtual ++;
        }


    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO"};
        System.err.println("Imprimindo a lista de selecionados informando o índice");
        for(int indice = 0; indice < candidatos.length; indice ++){
            System.err.println("O candidato de n°" + (indice+1) + " é: " + candidatos[indice]);
        }
    }

    static boolean atender() {
	    return new Random().nextInt(3)==1;	
	}
    
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2300);
    }
}