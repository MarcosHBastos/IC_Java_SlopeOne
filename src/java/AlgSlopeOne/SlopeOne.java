/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgSlopeOne;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public class SlopeOne {

    public static double[][] normalizaAvaliacoes(Usuario[] users) {
        double[][] norm = new double[users.length][6];
        double somatorio = 0, media = 0;

        for (int i = 0; i < users.length; i++) {
            for (double aux : users[i].getNotas()) {
                somatorio += aux;
            }
            media = somatorio != 0 ? somatorio / 6 : 0;

            for (int j = 0; j < 6; j++) {
                norm[i][j] = users[i].getNotas()[j] - media;
            }
            somatorio = 0;
        }
        return norm;
    }

    //retorna um vetor com os IDs dos usuarios semelhantes (o id é o índice no vetor de usuarios)
    public static int[] distanciaCosseno(Usuario uPrever, Usuario[] outrosUsers) {
        double[] somProdutoItensEmComum = new double[outrosUsers.length];
        Double[] todasDistCos = new Double[outrosUsers.length];

        double[][] normNotas = normalizaAvaliacoes(outrosUsers);

        //novo*
        boolean igual = true;
        double[] normPrev = new double[uPrever.getNotas().length];
        for (int i = 0; i < uPrever.getNotas().length; i++) {
            if (uPrever.getNotas()[0] != uPrever.getNotas()[i]) {
                igual = false;
                break;
            }
        }

        if (!igual) {
            double som = 0, media = 0;

            for (int i = 0; i < normPrev.length; i++) {
                som += uPrever.getNotas()[i];
            }
            media = som / normPrev.length;
            for (int i = 0; i < normPrev.length; i++) {
                normPrev[i] = uPrever.getNotas()[i] - media;
            }
        } else {
            normPrev = uPrever.getNotas();
            double[][] aux = new double[outrosUsers.length][6];
            for (int i = 0; i < outrosUsers.length; i++) {
                for (int j = 0; j < 6; j++) {
                    aux[i][j] = outrosUsers[i].getNotas()[j];
                }
            }
            normNotas = aux;
        }
        //novo*

        //Calculando o numerador da equação da distância por cosseno
        for (int i = 0; i < outrosUsers.length; i++) {
            for (int j = 0; j < 5; j++) {
                somProdutoItensEmComum[i] += (normPrev[j] * normNotas[i][j]);
            }
        }

        //Raiz do somatório do quadrado das avaliações do usuário a se prever
        double somQuad = 0, raizSom = 0, outrosSomQuad = 0;
        for (int i = 0; i < uPrever.idAvaliados().length; i++) {
            somQuad += (Math.pow((normPrev[uPrever.idAvaliados()[i]]), 2));
        }
        raizSom = Math.sqrt(somQuad);

        //Calculando a distância cosseno com todos os usuários
        for (int i = 0; i < outrosUsers.length; i++) {
            for (int j = 0; j < outrosUsers[i].idAvaliados().length-1 /*menos um pra ignorar a avaliação não feita pelo uPrever*/; j++) {
                outrosSomQuad += (Math.pow(normNotas[i][outrosUsers[i].idAvaliados()[j]], 2));
            }
            if (somProdutoItensEmComum[i] != 0 && raizSom != 0 && outrosSomQuad != 0) {
                todasDistCos[i] = (Math.ceil((somProdutoItensEmComum[i] / (raizSom * Math.sqrt(outrosSomQuad)))*1000))/1000;
            } else {
                todasDistCos[i] = 0.0;
            }
            outrosSomQuad = 0;
        }

//Se as notas informadas pelo usuário a se prever forem iguais inverte o sinal do cosseno, conforme observado necessário na depuração
        /*if(igual) {
            for (int i=0 ; i<todasDistCos.length ; i++) {
                todasDistCos[i] = -todasDistCos[i];
            }
        }*/

//Definindo a quantidade de usuários semelhantes a se usar        
        int maxComp = Math.floorDiv(outrosUsers.length, 3);
        int[] retorno = new int[maxComp];
/*
        int n=0;
        for(int i=0 ; i<todasDistCos.length ; i++) {
            if(todasDistCos[i] > 1.5)
                n++;
        }
        n = (n > (Math.floorDiv(outrosUsers.length, 3))) ? (Math.floorDiv(outrosUsers.length, 3)) : n; 
        n = (n == 0) ? 1 : n;*/
        
        
//Criando array auxiliar para encontrar os maiores valores de distância encontradas sem perder os índices
        Double[] aux = new Double[todasDistCos.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = todasDistCos[i];
        }
        Arrays.sort(aux, Collections.reverseOrder());

//Encontrando os índices dos maiores valores de distância encontradas        
        for (int i = 0; i < maxComp; i++) {
            for (int j = 0; j < todasDistCos.length; j++) {
                if (todasDistCos[j] == aux[i]) {
                    retorno[i] = j;
                    break;
                }
            }
        }
        /* Desnecessário
        //condicionando o retorno de usuários próximos, não utilizado no momento só para testes
        for (int i = 0; i < todasDistCos.length; i++) {
            if (todasDistCos[retorno[0]] >= todasDistCos[i]) {
                for (int j = maxComp - 1; j > 0; j--) {
                    retorno[j] = retorno[j - 1];
                }
                retorno[0] = i;
            }
        }
        for (int i = 0; i < retorno.length; i++) {
        }*/
        return retorno;
    }

    public static double slopeOne(Usuario u, int idItem) {

        Usuario[] todos;
        todos = Registro.getUsuarios();

        /////////////////////////////////
        float somDif = 0, somFinal = 0;
        float mDif[] = new float[u.idAvaliados().length]; //u id avaliados lenght vai ser sempre = 5 
        double[][] difUJ = new double[todos.length][u.getNotas().length]; //todos lenght ta certo, u get notas length = 5

        int[] usuariosSemelhantes = distanciaCosseno(u, todos);

        for (int i = 0; i < usuariosSemelhantes.length; i++) {
            for (int j = 0; j < u.idAvaliados().length; j++) {
                difUJ[i][j] = todos[usuariosSemelhantes[i]].getNotas()[idItem - 1] - todos[usuariosSemelhantes[i]].getNotas()[u.idAvaliados()[j]];
            }
        }

        //Calculando a media de avaliações dos itens baseado em todos os usuários
        for (int m = 0; m < u.idAvaliados().length; m++) {
            for (int n = 0; n < usuariosSemelhantes.length; n++) {

                somDif += difUJ[n][m];    //Somatório das diferenças

            }
            mDif[m] = somDif / usuariosSemelhantes.length;     //Média das diferenças do item M
            somDif = 0;
        }

        //Previsão
        for (int m = 0; m < u.idAvaliados().length; m++) {

            somFinal += u.getNotas()[u.idAvaliados()[m]] + mDif[m];   //Somatório das notas com as médias

        }
        double resultado = somFinal / u.idAvaliados().length;

        if (resultado > 5) {
            return 5;
        }
        if (resultado < 0) {
            return 0;
        }
        return resultado;
    }
}
