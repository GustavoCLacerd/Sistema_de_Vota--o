package Sistema_de_Votação;

import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;
class Metodos {
    int QtdVotos [][] = new int [2][200];
    public Construtor [] Cadastrar (Construtor [] vt1){
        int j;
        Random gerar = new Random ();

        for (j = 0; j < 200; j++){
            vt1 [j].NumeroSeção = gerar.nextInt(11);
            vt1 [j].NumeroCandidato = gerar.nextInt( 201);
                }
        return vt1;
    }

    public Construtor [] Classificar (Construtor [] vt2){
        int antes, depois;

        for (antes = 0; antes < 199; antes++){
            for (depois = (antes + 1); depois < 200; depois++){
                if (vt2 [antes].NumeroSeção > vt2 [depois].NumeroSeção){
                    vt2[199].NumeroSeção = vt2 [antes].NumeroSeção;
                    vt2 [antes].NumeroSeção = vt2 [depois].NumeroSeção;
                    vt2 [depois].NumeroSeção = vt2 [199].NumeroSeção;
            
                    vt2[199].NumeroCandidato = vt2 [antes].NumeroCandidato;
                    vt2 [antes].NumeroCandidato = vt2 [depois].NumeroCandidato;
                    vt2 [depois].NumeroCandidato = vt2 [199].NumeroCandidato;
                }

            }
        }
        return vt2;
    }

    public Construtor [] Gravar (Construtor [] vt3) throws IOException{
        String NomeArquivo = "VotosRegistro";
        BufferedWriter gravar = new BufferedWriter (new FileWriter (NomeArquivo));
        for (int i = 0; i < vt3.length; i++){
            gravar.write (Integer.toString (vt3 [i].NumeroSeção));
                gravar.newLine ();
            gravar.write (Integer.toString (vt3 [i].NumeroSeção));
                gravar.newLine ();      
        }
        gravar.close();
        JOptionPane.showMessageDialog (null, "Arquivo gerado.");
        return vt3;
    }

    public void Quantidade (Construtor [] vt4){
    int  cta = 1, soma = 0;

    while (cta < 11){
        for (int i = 0; i < 200; i++){
            if (vt4[i].NumeroSeção == cta){
                soma = soma + 1;
            }
        }
    System.out.println ("A seção " +cta +" tem "+soma +" eleitores!");
    soma = 0;
    cta = cta + 1;
    }
    }

    public void MaiorMenor (Construtor [] vt4){
        int  cta = 1, soma [] = new int [11], maior, menor, maior1 = 0, menor1 = 0;
        while (cta < 11){
            for (int i = 0; i < 200; i++){
                if (vt4[i].NumeroSeção == cta){
                    soma [cta] = soma [cta] + 1;
                }
            }
        cta = cta + 1;
        }
        maior = Integer.MIN_VALUE;
        menor = Integer.MAX_VALUE;
        for (cta = 1; cta < 11; cta ++){
            if(soma[cta] > maior) { 
                maior = soma [cta];
                maior1 = cta;
            }
            if (soma[cta] < menor) { 
                menor = soma [cta];
                menor1 = cta;
            }
        }
        JOptionPane.showMessageDialog (null, "A seção com maior número de eleitores é: "+maior1 +" e a menor é: " +menor1);
    }

    public void VotosCandidato (Construtor [] vt5){
    int cta = 0, soma = 0;
    while (cta < 301){
        for (int i = 0; i < 200; i++){
            if (vt5 [i].NumeroCandidato == cta){
                soma = soma + 1;  
            }
        }
        System.out.println ("O  candidato número "+cta +" tem " +soma +" votos.");
        cta = cta + 1;
        soma = 0;
    }
    }

    public void CandidatosMaisVotados (Construtor [] vt6){
        for (int i = 0; i < QtdVotos[0].length; i++) {
            QtdVotos[0][i] = 0;
        }
        for (int ctdr2 = 0; ctdr2 < vt6.length; ctdr2++) {
            int auxiliar1 = vt6[ctdr2].NumeroCandidato;
            QtdVotos[0][auxiliar1]++;
            QtdVotos[1][auxiliar1] = auxiliar1;
        }
        for (int anterior = 0; anterior < QtdVotos[0].length - 1; anterior++) {
            for (int proximo = anterior + 1; proximo < QtdVotos[0].length; proximo++) {
                if (QtdVotos[0][anterior] < QtdVotos[0][proximo]) {
                    int auxVotos = QtdVotos[0][anterior];
                    QtdVotos[0][anterior] = QtdVotos[0][proximo];
                    QtdVotos[0][proximo] = auxVotos;
                    int auxCandidato = QtdVotos[1][anterior];
                    QtdVotos[1][anterior] = QtdVotos[1][proximo];
                    QtdVotos[1][proximo] = auxCandidato;
                }
            }
        }
        for (int auxiliar2 = 0; auxiliar2 < 10; auxiliar2++) {
            JOptionPane.showMessageDialog(null, 
                    "Posição no ranking: " + (auxiliar2 + 1) + "\n"
                    + "Candidato: " + QtdVotos[1][auxiliar2] + "\n"
                    + "Votos: " + QtdVotos[0][auxiliar2]);
        }
    }
    }
