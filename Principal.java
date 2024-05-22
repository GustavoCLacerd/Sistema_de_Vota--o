package Sistema_de_Votação;

import java.io.*;
import javax.swing.JOptionPane;
class Principal {
    public static void main (String Args []) throws IOException {
    int codigo1 = 0;

    Construtor vt [] = new Construtor [200];

    for (int i = 0; i < 200; i++){
        vt [i] = new Construtor();
    }
    
    Metodos m = new Metodos();
    
    while (codigo1 != 9){
        codigo1 = Integer.parseInt (JOptionPane.showInputDialog ("1 - Carregar Seção/Número Eleitor\n"+
        "2 - Classificar por Seção\n"+
        "3 - Gravar Registros\n"+
        "4 - Mostrar Indicadores\n"+
        "9 - Finalizar"));

    switch (codigo1) {
        case 1:
        m.Cadastrar(vt);
        break;
        case 2:
        m.Classificar(vt);
        break;
        case 3:
        m.Gravar(vt);
        break;
        case 4:
        int codigo2 = 0;
        while (codigo2 != 9){
            codigo2 = Integer.parseInt (JOptionPane.showInputDialog ("1 - Quantidade Eleitores por Seção\n"+
            "2 - Seção com Maior e Menor número de Eleitores\n"+
            "3 - Quantidade de votos por candidato\n"+
            "4 - 10 primeiros colocadas (nro cand. e qtd votos)\n"+
            "9 - Finaliza consulta"));
    
        switch (codigo2) {
            case 1:
            m.Quantidade(vt);
            break;
            case 2:
            m.MaiorMenor(vt);
            break;
            case 3:
            m.VotosCandidato(vt);
            break;
            case 4:
            m.CandidatosMaisVotados(vt);
            break;
            case 9: JOptionPane.showMessageDialog (null, "Consulta encerrada!");
            break;
            default: JOptionPane.showMessageDialog (null, "Opção inválida");
            break;
        }
        }
        break;
        case 9: JOptionPane.showMessageDialog (null, "Programa encerrado!");
        break;
        default: JOptionPane.showMessageDialog (null, "Opção inválida");
        break;
    }
    }
    }
}
