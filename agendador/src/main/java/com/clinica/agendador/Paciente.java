import java.util.Random;

class Paciente {
    private String nome;
    private String endereco;
    private String telefone;
    private String tipoAtendimento; // "Convenio" ou "Particular"

    public Paciente(String nome, String endereco, String telefone, String tipoAtendimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getTipoAtendimento() { return tipoAtendimento; }
}

class Medico {
    private String nome;
    private String especialidade;

    public Medico(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
}

class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String dataHora;
    private String codigoValidador;

    public Consulta(Paciente paciente, Medico medico, String dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.codigoValidador = gerarValidador();
    }

    private String gerarValidador() {
        Random random = new Random();
        int numero = 100000 + random.nextInt(900000); // Código aleatório de 6 dígitos
        return "VAL-" + numero;
    }

    public void enviarComprovante() {
        System.out.println("\n==========================================");
        System.out.println("   [SIMULAÇÃO DE ENVIO PARA O WHATSAPP/SMS]");
        System.out.println("   Enviando para o número: " + paciente.getTelefone());
        System.out.println("==========================================");
        System.out.println("Olá, " + paciente.getNome() + "! Sua consulta foi agendada.");
        System.out.println("Especialidade: " + medico.getEspecialidade());
        System.out.println("Médico(a): " + medico.getNome());
        System.out.println("Data/Hora: " + dataHora);
        System.out.println("Tipo: " + paciente.getTipoAtendimento());
        System.out.println("Código Validador: " + codigoValidador);
        System.out.println("==========================================\n");
    }
}
