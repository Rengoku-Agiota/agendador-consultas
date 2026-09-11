package com.clinica.agendador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendamentoController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Base de Dados Simulada (Médicos e Especialidades)
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico("Dr. Carlos Silva", "Ortopedia"));
        medicos.add(new Medico("Dra. Amanda Costa", "Ortopedia"));
        medicos.add(new Medico("Dr. Roberto Lima", "Dentista"));
        medicos.add(new Medico("Dra. Patricia Souza", "Ginecologia"));
        medicos.add(new Medico("Dr. Fernando Rocha", "Exames"));

        System.out.println("==========================================");
        System.out.println("      SISTEMA DE AGENDAMENTO MÉDICO       ");
        System.out.println("==========================================");

        // ETAPA 1: Cadastro do Usuário
        System.out.println("\n--- Passo 1: Cadastro ---");
        System.out.print("Nome Completo: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Telefone de Contato (WhatsApp/SMS): ");
        String telefone = scanner.nextLine();

        System.out.println("Tipo de Atendimento:");
        System.out.println("1 - Convênio Médico");
        System.out.println("2 - Particular");
        System.out.print("Opção: ");
        int opcaoTipo = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        String tipoAtendimento = (opcaoTipo == 1) ? "Convênio Médico" : "Particular";
        Paciente paciente = new Paciente(nome, endereco, telefone, tipoAtendimento);

        // ETAPA 2: Escolha da Especialidade
        System.out.println("\n--- Passo 2: Selecione a Especialidade ---");
        List<String> especialidades = List.of("Ortopedia", "Dentista", "Ginecologia", "Exames");

        for (int i = 0; i < especialidades.size(); i++) {
            System.out.println((i + 1) + " - " + especialidades.get(i));
        }
        System.out.print("Escolha a especialidade: ");
        int opEspecialidade = scanner.nextInt();
        scanner.nextLine();

        String especialidadeEscolhida = especialidades.get(opEspecialidade - 1);

        // ETAPA 3: Médicos Disponíveis para a Especialidade
        System.out.println("\n--- Passo 3: Médicos Disponíveis ---");
        List<Medico> medicosFiltrados = new ArrayList<>();

        for (Medico m : medicos) {
            if (m.getEspecialidade().equalsIgnoreCase(especialidadeEscolhida)) {
                medicosFiltrados.add(m);
            }
        }

        for (int i = 0; i < medicosFiltrados.size(); i++) {
            System.out.println((i + 1) + " - " + medicosFiltrados.get(i).getNome());
        }
        System.out.print("Escolha o(a) médico(a): ");
        int opMedico = scanner.nextInt();
        scanner.nextLine();

        Medico medicoEscolhido = medicosFiltrados.get(opMedico - 1);

        // ETAPA 4: Seleção de Data e Horário
        System.out.println("\n--- Passo 4: Datas e Horários Disponíveis ---");
        List<String> horariosDisponiveis = List.of(
                "15/10/2026 às 09:00",
                "15/10/2026 às 14:30",
                "16/10/2026 às 10:00"
        );

        for (int i = 0; i < horariosDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + horariosDisponiveis.get(i));
        }
        System.out.print("Escolha o horário: ");
        int opHorario = scanner.nextInt();

        String horarioEscolhido = horariosDisponiveis.get(opHorario - 1);

        // ETAPA 5: Finalização, Geração do Validador e Envio
        Consulta consulta = new Consulta(paciente, medicoEscolhido, horarioEscolhido);
        consulta.enviarComprovante();

        scanner.close();
    }
}
