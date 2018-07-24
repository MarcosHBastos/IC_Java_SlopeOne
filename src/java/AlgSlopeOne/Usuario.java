/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgSlopeOne;

/**
 *
 * @author Marcos
 */
public class Usuario {

    private double[] notas = new double[5]; //total de itenss
 
    public Usuario(double[] notas) {

        this.notas = notas;
    }
    
    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    //retorna um vetor com os IDs dos itens não avaliados (o id do item é o seu índice no vetor de avaliações)
    public int[] idNaoAvaliados() {
        int[] vet = null;
        return vet;
    }

    //retonr um vetor com os IDs dos itens avaliados (com valor diferente de NULL)
    public int[] idAvaliados() {
        int cont = 0;
        for (int i = 0; i < this.notas.length; i++) {
            if (this.notas[i] >= 0) {
                cont++;
            }
        }

        int[] retorno = new int[cont];

        
        for (int i=0, j=0 ; i<cont ; i++ ) {
            if(this.notas[i] >= 0 ) {
                retorno[j] = i;
                j++;
            }
        }
        return retorno;
    }


}
